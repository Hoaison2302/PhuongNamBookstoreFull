package com.hungviet.phuongnambookstore.Activity.Sach;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hungviet.phuongnambookstore.Activity.Create_Accout.TaoTaiKhoan1;
import com.hungviet.phuongnambookstore.Activity.Login_To_Facebook.Login_to_facebookActivity;
import com.hungviet.phuongnambookstore.Activity.Lay_Lai_Tai_Khoan.QuenMatKhau1Activity;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.model.Person;

import java.util.List;

public class Welcome extends BaseActivity {
    private EditText edtuser,edtpass;
    private Person person;
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        edtpass=findViewById(R.id.pass);
        edtuser = findViewById(R.id.user);


        person=new Person();

        SachSqlite nguoidungSqlite = new SachSqlite(this);
        nguoidungSqlite.createDataBase();
    }
    public void LayLaiTaiKhoan(View view) {

            openActivity(QuenMatKhau1Activity.class);





    }
    public void TaoTaiKhoan(View view) {
        openActivity(TaoTaiKhoan1.class);
    }

    public void login(View view) {

        String us = edtpass.getText().toString().trim();
        String pass = edtpass.getText().toString().trim();
        if (us.equals("admin") && pass.equals("admin")){
            openActivity(HomeActivity.class);
            Toast.makeText(Welcome.this,"Login successfully!",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(Welcome.this,"Login Faild!",Toast.LENGTH_SHORT).show();
        }
    }

    public void Login_to_FaceBook(View view) {
        openActivity(Login_to_facebookActivity.class);
    }


}
