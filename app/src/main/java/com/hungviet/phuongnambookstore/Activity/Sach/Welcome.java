package com.hungviet.phuongnambookstore.Activity.Sach;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hungviet.phuongnambookstore.Activity.Create_Accout.TaoTaiKhoan1Activity;
import com.hungviet.phuongnambookstore.Activity.Login_To_Facebook.Login_to_facebookActivity;
import com.hungviet.phuongnambookstore.Activity.Lay_Lai_Tai_Khoan.QuenMatKhau1Activity;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.BaseActivity;

public class Welcome extends BaseActivity {
    private EditText edtuser,edtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        edtpass=findViewById(R.id.pass);
        edtuser = findViewById(R.id.user);
    }
    public void LayLaiTaiKhoan(View view) {
        openActivity(QuenMatKhau1Activity.class);
    }
    public void TaoTaiKhoan(View view) {
        openActivity(TaoTaiKhoan1Activity.class);
    }

    public void login(View view) {

        String user=edtuser.getText().toString().trim();
        String pass=edtpass.getText().toString().trim();
        if (user.equalsIgnoreCase("Admin" )&& pass.equalsIgnoreCase("Admin")){
            openActivity(HomeActivity.class);
        }
    }

    public void Login_to_FaceBook(View view) {
        openActivity(Login_to_facebookActivity.class);
    }
}
