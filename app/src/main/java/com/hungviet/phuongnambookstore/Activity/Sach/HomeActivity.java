package com.hungviet.phuongnambookstore.Activity.Sach;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_BanActivity;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_NhapActivity;
import com.hungviet.phuongnambookstore.Activity.Lay_Lai_Tai_Khoan.QuenMatKhau1Activity;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin.Thong_tinActivity;
import com.hungviet.phuongnambookstore.Activity.Thong_Ke.Thong_KeActivity;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin_Nguoi_Dung.Thong_Tin_Nguoi_DungActivity;
import com.hungviet.phuongnambookstore.Activity.Top_Ban_Chay.Top_Ban_ChayActivity;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.model.Sach.Sach;
import com.hungviet.phuongnambookstore.Adapter.SachAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    private List<Sach> sachList;
    private List<Sach> sachListful;
    private SachAdapter sachAdapter;
    private RecyclerView recyclerView;
    private ImageView imageView;
    private FloatingActionButton floatingActionButton;
    private SachDao sachDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView=findViewById(R.id.recycler);
        imageView=findViewById(R.id.tvluachon);
        floatingActionButton=findViewById(R.id.floatingActionButton);

        sachDao=new SachDao(this);
        sachList=sachDao.getAll();
        sachListful=sachDao.getAll();

        Drawable drawable= getResources().getDrawable(R.drawable.pri);
//...
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        sachAdapter = new SachAdapter(sachList,this,sachListful);
        sachAdapter.notifyDataSetChanged();
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(sachAdapter);



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Them_SachActivity.class);
            }
        });






    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.dangxuat:
                openActivity(Welcome.class);
                break;

            case R.id.thongke:
                openActivity(Thong_KeActivity.class);
                break;
            case R.id.thongtinnguoidung:
                openActivity(Thong_Tin_Nguoi_DungActivity.class);
                break;
            case R.id.hoadonnhap:
                openActivity(Hoa_Don_NhapActivity.class);
                break;
            case R.id.thongtin:
                openActivity(Thong_tinActivity.class);
                break;
            case R.id.sachbanchay:
                openActivity(Top_Ban_ChayActivity.class);
                break;

            case R.id.hoadonban:
                openActivity(Hoa_Don_BanActivity.class);
                break;

            case R.id.quanlysachtonkho:
                openActivity(Hoa_Don_NhapActivity.class);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.home, menu);

        MenuItem searchItem=menu.findItem(R.id.app_bar_search);
        SearchView searchView=(SearchView) searchItem.getActionView();

        searchView.setQueryHint("Search....");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                sachAdapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }
}
