package com.hungviet.phuongnambookstore.Activity.Sach;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.hungviet.phuongnambookstore.Activity.Create_Accout.TaoTaiKhoan1;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_BanActivity;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_NhapActivity;
import com.hungviet.phuongnambookstore.Activity.Lay_Lai_Tai_Khoan.QuenMatKhau1Activity;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin.Thong_tinActivity;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin_Nguoi_Dung.Thong_Tin_Nguoi_DungActivity;
import com.hungviet.phuongnambookstore.Activity.Thong_Ke.Thong_KeActivity;
import com.hungviet.phuongnambookstore.Activity.Top_Ban_Chay.Top_Ban_ChayActivity;
import com.hungviet.phuongnambookstore.Adapter.SachAdapter;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.model.Sach.Sach;

public class Them_SachActivity extends BaseActivity {
    private Sach sachlist;
    private SachAdapter sachAdapter;
    Button btnthem;
    private SachDao sachDao;
    private TextInputEditText edttensach,edttacgia,edtgia,edtluotxem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them__sach);
        btnthem = findViewById(R.id.btnthem);
        Drawable drawable= getResources().getDrawable(R.drawable.close);
        sachDao=new SachDao(this);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);



        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                edttensach=findViewById(R.id.btntensachthem);
                edtgia=findViewById(R.id.btntacgiathem);
                edtluotxem=findViewById(R.id.btnluotxemthem);
                edttacgia=findViewById(R.id.btntacgiathem);





                String tensach = edttensach.getText().toString().trim();
                String gia = String.valueOf(edtgia.getText().toString().trim());
                String luotxem = String.valueOf(edtluotxem.getText().toString().trim());
                String tacgia = edttacgia.getText().toString().trim();


                if (tensach.equals("")){
                    Toast.makeText(Them_SachActivity.this,"Vui Lòng Nhập Tên Sách!",Toast.LENGTH_SHORT).show();
                }else if (tacgia.equals("")){
                    Toast.makeText(Them_SachActivity.this,"Vui Lòng Nhập Tác Giả!",Toast.LENGTH_SHORT).show();
                }else if (gia.equals("")){
                    Toast.makeText(Them_SachActivity.this,"Vui Lòng Nhập Giá Và Không Kèm Ký Tự Đặc Biệt!",Toast.LENGTH_SHORT).show();
                }else if (luotxem.equals("")){
                    Toast.makeText(Them_SachActivity.this,"Vui Lòng Nhập Lượt Xem Và Không Kèm Ký Tự Đặc Biệt!",Toast.LENGTH_SHORT).show();
                }else {
                    sachlist = new Sach();
                    sachlist.setTen(edttensach.getText().toString().trim());
                    sachlist.setGia(Integer.parseInt(edtgia.getText().toString().trim()));
                    sachlist.setLuotxem(Integer.parseInt(edtluotxem.getText().toString().trim()));
                    sachlist.setTacgia(edttacgia.getText().toString().trim());
                    long resurt = sachDao.insertUser(sachlist);
                    if(resurt>0){
                        Toast.makeText(Them_SachActivity.this,"Thêm Sách Thành Công!",Toast.LENGTH_SHORT).show();
                        openActivity(HomeActivity.class);
                    }else if (resurt<0){
                        Toast.makeText(Them_SachActivity.this,"Thêm Sách Thất Bại!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }

    public void openActivity(View view) {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
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
        getMenuInflater().inflate(R.menu.home,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
