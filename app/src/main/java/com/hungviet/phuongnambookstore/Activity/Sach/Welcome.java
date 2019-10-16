package com.hungviet.phuongnambookstore.Activity.Sach;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hungviet.phuongnambookstore.Activity.Create_Accout.TaoTaiKhoan1;
import com.hungviet.phuongnambookstore.Activity.Login_To_Facebook.Login_to_facebookActivity;
import com.hungviet.phuongnambookstore.Activity.Lay_Lai_Tai_Khoan.QuenMatKhau1Activity;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.model.Person;

public class Welcome extends BaseActivity {
    private EditText edtuser,edtpass;
    private Person person;

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
        openActivity(HomeActivity.class);
    }

    public void Login_to_FaceBook(View view) {
        openActivity(Login_to_facebookActivity.class);
    }
}
