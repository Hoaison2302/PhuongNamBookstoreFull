package com.hungviet.phuongnambookstore.Activity.Create_Accout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.hungviet.phuongnambookstore.Activity.Sach.Welcome;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin_Nguoi_Dung.NguoiDungDao;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin_Nguoi_Dung.Thong_Tin_Nguoi_DungActivity;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.model.Person;

import java.util.List;

public class TaoTaiKhoan1 extends BaseActivity {
    private TextInputEditText sdt,email,hoten,matkhau;
    private Person person;
    List<Person> personList;
    private NguoiDungDao nguoiDungDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_tai_khoan2);
        sdt=findViewById(R.id.sdt);
        email=findViewById(R.id.email);
        hoten=findViewById(R.id.hoten);
        matkhau=findViewById(R.id.matkhau);
        Drawable drawable= getResources().getDrawable(R.drawable.close);
//...
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    public void dangky(View view) {

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        View dialog  = LayoutInflater.from(this).inflate(R.layout.giaodien,null);
//        builder.setView(dialog);
//
//        builder.create();
//        builder.show();
//




        nguoiDungDao =new NguoiDungDao(TaoTaiKhoan1.this);

        person =new Person();

        person.setSdt(Integer.parseInt(sdt.getText().toString().trim()));
        person.setEmail(email.getText().toString().trim());
        person.setHoten(hoten.getText().toString().trim());
        person.setMatkhau(matkhau.getText().toString().trim());



        String sdtt = sdt.getText().toString().trim();
        String emaill = email.getText().toString().trim();
        String hotenn = hoten.getText().toString().trim();
        String matkhauu = matkhau.getText().toString().trim();


        if (sdtt.equals("")){
            Toast.makeText(this,"Vui Lòng Nhập Số Điện thoại",Toast.LENGTH_SHORT).show();
        }else if (emaill.equals("")){
            Toast.makeText(this,"Vui Lòng Nhập Email",Toast.LENGTH_SHORT).show();
        }else if (hotenn.equals("")){
            Toast.makeText(this,"Vui Lòng Nhập Họ Tên",Toast.LENGTH_SHORT).show();
        }else if (matkhauu.equals("")){
            Toast.makeText(this,"Vui Lòng Nhập Mật Khẩu",Toast.LENGTH_SHORT).show();
        }else {
            long resurt = nguoiDungDao.insertUser(person);
            if(resurt>0){
                Toast.makeText(TaoTaiKhoan1.this,"Thêm Người Dùng Thành Công",Toast.LENGTH_SHORT).show();
                openActivity(Welcome.class);


            }

        }
}}
