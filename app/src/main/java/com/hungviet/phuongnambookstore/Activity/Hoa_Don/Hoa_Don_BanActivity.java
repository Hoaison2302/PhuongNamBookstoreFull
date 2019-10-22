package com.hungviet.phuongnambookstore.Activity.Hoa_Don;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
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
import com.hungviet.phuongnambookstore.Activity.Sach.Them_SachActivity;
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
import java.util.Calendar;
import java.util.List;

public class Hoa_Don_BanActivity extends BaseActivity {
    private Hoa_Don_BanAdapter hoa_don_banAdapter;
    private List<Hoa_Don_Ban> hoa_don_banList;
    private Hoa_Don_Ban hoa_don_ban;
    private Hoa_Don_Ban_Dao hoa_don_ban_dao;
    private RecyclerView recyclerView;
    AlertDialog alertDialog;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa__don__ban);
        recyclerView = findViewById(R.id.rc_hoa_don_ban);
        floatingActionButton=findViewById(R.id.floatingActionButton4);
        Drawable drawable= getResources().getDrawable(R.drawable.pri);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        hoa_don_ban_dao = new Hoa_Don_Ban_Dao(this);
        hoa_don_banList=hoa_don_ban_dao.getAll();

        hoa_don_banAdapter = new Hoa_Don_BanAdapter(hoa_don_banList,this);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(hoa_don_banAdapter);



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Hoa_Don_BanActivity.this);
                View dialog  = LayoutInflater.from(Hoa_Don_BanActivity.this).inflate(R.layout.them_hoa_don_ban,null);
                builder.setView(dialog);


                ImageView btnngay;

                final TextInputEditText edttheloai,edttensach,edtgia,edtsoluong,edtmasach,edtngayy;
                final Button ok,cancel;
                edtngayy=dialog.findViewById(R.id.edtngayi);
                btnngay=dialog.findViewById(R.id.btnngayi);
                ok=dialog.findViewById(R.id.btnoki);
                cancel=dialog.findViewById(R.id.btncanceli);

                edttheloai=dialog.findViewById(R.id.edttheloaii);
                edttensach=dialog.findViewById(R.id.edttensachi);
                edtgia=dialog.findViewById(R.id.edtgiai);
                edtsoluong=dialog.findViewById(R.id.edtsoluongi);
                edtmasach=dialog.findViewById(R.id.edtmasachi);

                btnngay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Calendar calendar=Calendar.getInstance(); //khoi tao
                        int nam=calendar.get(Calendar.YEAR);  //thiet lap ngay thang nam
                        int thang=calendar.get(Calendar.MONTH);  //thiet lap ngay thang nam
                        int ngay=calendar.get(Calendar.DAY_OF_MONTH);  //thiet lap ngay thang nam
                        DatePickerDialog dialog=new DatePickerDialog(Hoa_Don_BanActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                edtngayy.setText(view.getDayOfMonth()+"/"+(view.getMonth()+1)+"/"+view.getYear());

                            }
                        },nam,thang,ngay);
                        dialog.show();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });


                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String theloai = edttheloai.getText().toString().trim();
                        String tensach = edttensach.getText().toString().trim();
                        String soluong = edtsoluong.getText().toString().trim();
                        String gianhap = edtgia.getText().toString().trim();
                        String ngaynhap = edtngayy.getText().toString().trim();
                        String mahoadonnhap = edtmasach.getText().toString().trim();

                        if (theloai.equals("")){
                            Toast.makeText(Hoa_Don_BanActivity.this,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else if (tensach.equals("")){
                            Toast.makeText(Hoa_Don_BanActivity.this,"Vui Lòng Nhập Tên Sách!",Toast.LENGTH_SHORT).show();
                        }else if (ngaynhap.equals("")){
                            Toast.makeText(Hoa_Don_BanActivity.this,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else if (soluong.equals("")){
                            Toast.makeText(Hoa_Don_BanActivity.this,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else if (gianhap.equals("")){
                            Toast.makeText(Hoa_Don_BanActivity.this,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else if (mahoadonnhap.equalsIgnoreCase("")){
                            Toast.makeText(Hoa_Don_BanActivity.this,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else {
                        hoa_don_ban_dao =new Hoa_Don_Ban_Dao(Hoa_Don_BanActivity.this);

                        hoa_don_ban=new Hoa_Don_Ban();

                        hoa_don_ban.setTheloai(edttheloai.getText().toString().trim());
                        hoa_don_ban.setTensach(edttensach.getText().toString().trim());
                        hoa_don_ban.setSoluongban(edtsoluong.getText().toString().trim());
                        hoa_don_ban.setNgayban(edtngayy.getText().toString());
                        hoa_don_ban.setMahoadonban(edtmasach.getText().toString().trim());
                        hoa_don_ban.setGiaban(edtgia.getText().toString().trim());


                        long resurt = hoa_don_ban_dao.insertUser(hoa_don_ban);

                        if(resurt>0){
                            Toast.makeText(Hoa_Don_BanActivity.this,"Thêm Thành Công!",Toast.LENGTH_SHORT).show();


                            Intent intent
                                    =new Intent(Hoa_Don_BanActivity.this,Hoa_Don_BanActivity.class
                            );startActivity(intent);
                            alertDialog.dismiss();
                        }else {
                            Toast.makeText(Hoa_Don_BanActivity.this,"Thêm 0 dc",Toast.LENGTH_SHORT).show();
                            alertDialog.dismiss();
                        }}
                    }
                });



                builder.create();
                alertDialog=builder.show();
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
