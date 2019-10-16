package com.hungviet.phuongnambookstore.Activity.Hoa_Don;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.hungviet.phuongnambookstore.Activity.Lay_Lai_Tai_Khoan.QuenMatKhau1Activity;
import com.hungviet.phuongnambookstore.Activity.Sach.Welcome;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin.Thong_tinActivity;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin_Nguoi_Dung.Thong_Tin_Nguoi_DungActivity;
import com.hungviet.phuongnambookstore.Activity.Thong_Ke.Thong_KeActivity;
import com.hungviet.phuongnambookstore.Activity.Top_Ban_Chay.Top_Ban_ChayActivity;
import com.hungviet.phuongnambookstore.Adapter.Hoa_Don_BanAdapter;
import com.hungviet.phuongnambookstore.Adapter.Hoa_Don_NhapAdapter;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Ban;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Nhap;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Hoa_Don_NhapActivity extends BaseActivity {

    private Hoa_Don_NhapAdapter hoa_Don_NhapAdapter;
    private List<Hoa_Don_Nhap> hoa_don_nhapList;
    private Hoa_Don_Nhap_Dao hoa_don_nhap_dao;
    private RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa__don__nhap);
        recyclerView=findViewById(R.id.rvhoadonnhap);
        floatingActionButton=findViewById(R.id.floatingActionButton2);

        Drawable drawable= getResources().getDrawable(R.drawable.pri);
//...
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        hoa_don_nhap_dao = new Hoa_Don_Nhap_Dao(this);
        hoa_don_nhapList=hoa_don_nhap_dao.getAll();





        hoa_Don_NhapAdapter = new Hoa_Don_NhapAdapter(hoa_don_nhapList,this);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(hoa_Don_NhapAdapter);






//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(Hoa_Don_NhapActivity.this);
//                View dialog  = LayoutInflater.from(Hoa_Don_NhapActivity.this).inflate(R.layout.them_hoa_don_nhap,null);
//                builder.setView(dialog);
//
//
//                ImageView btnngay;
//
//                final TextInputEditText edttheloai,edttensach,edtgia,edtsoluong,edtmasach,edtngay;
//                final Button ok,cancel;
//                edtngay=dialog.findViewById(R.id.edtngay);
//                btnngay=dialog.findViewById(R.id.btnngay);
//                ok=dialog.findViewById(R.id.btnok);
//                cancel=dialog.findViewById(R.id.btncancel);
//
//                edttheloai=dialog.findViewById(R.id.edttheloai);
//                edttensach=dialog.findViewById(R.id.edttensach);
//                edtgia=dialog.findViewById(R.id.edtgia);
//                edtsoluong=dialog.findViewById(R.id.edtsoluong);
//                edtmasach=dialog.findViewById(R.id.edtmasach);
//
//                btnngay.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Calendar calendar=Calendar.getInstance(); //khoi tao
//                        int nam=calendar.get(Calendar.YEAR);  //thiet lap ngay thang nam
//                        int thang=calendar.get(Calendar.MONTH);  //thiet lap ngay thang nam
//                        int ngay=calendar.get(Calendar.DAY_OF_MONTH);  //thiet lap ngay thang nam
//                        DatePickerDialog dialog=new DatePickerDialog(Hoa_Don_NhapActivity.this, new DatePickerDialog.OnDateSetListener() {
//                            @Override
//                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                                edtngay.setText(view.getDayOfMonth()+"/"+(view.getMonth()+1)+"/"+view.getYear());
//
//                            }
//                        },nam,thang,ngay);
//                        dialog.show();
//                    }
//                });
//

//                ok.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        hoa_don_ban_dao =new Hoa_Don_Ban_Dao(Hoa_Don_BanActivity.this);
//
//                        hoa_don_ban=new Hoa_Don_Ban();
//
//                        hoa_don_ban.setTheloai(edttheloai.getText().toString().trim());
//                        hoa_don_ban.setTensach(edttensach.getText().toString().trim());
//                        hoa_don_ban.setSoluongban(Integer.parseInt(edtsoluong.getText().toString().trim()));
//                        hoa_don_ban.setGiaban(Integer.parseInt(edtgia.getText().toString().trim()));
//                        hoa_don_ban.setNgayban(edtngay.getText().toString().trim());
//                        hoa_don_ban.setMahoadonban(edtmasach.getText().toString().trim());
//
//
//                        long resurt = hoa_don_ban_dao.insertUser(hoa_don_ban);
//
//                        if(resurt>0){
//                            Toast.makeText(Hoa_Don_BanActivity.this,"Thêm dc",Toast.LENGTH_SHORT).show();
//
//                            hoa_don_banAdapter.notifyDataSetChanged();
//                        }else {
//                            Toast.makeText(Hoa_Don_BanActivity.this,"Thêm 0 dc",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });



//                builder.create();
//                builder.show();
//            }
//        });
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
