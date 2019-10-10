package com.hungviet.phuongnambookstore.Activity.Hoa_Don;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hungviet.phuongnambookstore.Activity.Lay_Lai_Tai_Khoan.QuenMatKhau1Activity;
import com.hungviet.phuongnambookstore.Activity.Sach.Welcome;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin.Thong_tinActivity;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin_Nguoi_Dung.Thong_Tin_Nguoi_DungActivity;
import com.hungviet.phuongnambookstore.Activity.Thong_Ke.Thong_KeActivity;
import com.hungviet.phuongnambookstore.Activity.Top_Ban_Chay.Top_Ban_ChayActivity;
import com.hungviet.phuongnambookstore.Adapter.Hoa_Don_BanAdapter;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Ban;

import java.util.ArrayList;
import java.util.List;

public class Hoa_Don_BanActivity extends BaseActivity {
    private Hoa_Don_BanAdapter hoa_don_banAdapter;
    private List<Hoa_Don_Ban> hoa_don_banList;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa__don__ban);
        recyclerView = findViewById(R.id.rc_hoa_don_ban);
        floatingActionButton=findViewById(R.id.floatingActionButton4);
        Drawable drawable= getResources().getDrawable(R.drawable.pri);
//...
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        hoa_don_banList =new ArrayList<>();

        hoa_don_banList.add(new Hoa_Don_Ban("Thể loại: Kinh doanh",
                "Tên sách: Lãnh đạo 4.0","Ngày nhập: 22/09/2019","Số lương bán: 52","Giá bán: 80 $"));
        hoa_don_banList.add(new Hoa_Don_Ban("Thể loại: Kinh doanh",
                "Tên sách: Lãnh đạo 4.0","Ngày nhập: 22/09/2019","Số lương bán: 52","Giá bán: 80 $"));
        hoa_don_banList.add(new Hoa_Don_Ban("Thể loại: Kinh doanh",
                "Tên sách: Lãnh đạo 4.0","Ngày nhập: 22/09/2019","Số lương bán: 52","Giá bán: 80 $"));
        hoa_don_banList.add(new Hoa_Don_Ban("Thể loại: Kinh doanh",
                "Tên sách: Lãnh đạo 4.0","Ngày nhập: 22/09/2019","Số lương bán: 52","Giá bán: 80 $"));
        hoa_don_banList.add(new Hoa_Don_Ban("Thể loại: Kinh doanh",
                "Tên sách: Lãnh đạo 4.0","Ngày nhập: 22/09/2019","Số lương bán: 52","Giá bán: 80 $"));
        hoa_don_banList.add(new Hoa_Don_Ban("Thể loại: Kinh doanh",
                "Tên sách: Lãnh đạo 4.0","Ngày nhập: 22/09/2019","Số lương bán: 52","Giá bán: 80 $"));




        hoa_don_banAdapter = new Hoa_Don_BanAdapter(hoa_don_banList,this);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(hoa_don_banAdapter);



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Hoa_Don_BanActivity.this);
                View dialog  = LayoutInflater.from(Hoa_Don_BanActivity.this).inflate(R.layout.them_hoa_don_nhap,null);
                builder.setView(dialog);

                builder.create();
                builder.show();
            }
        });
    }
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
            case R.id.laylaimatkhau:
                openActivity(QuenMatKhau1Activity.class);
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
        getMenuInflater().inflate(R.menu.homes,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
