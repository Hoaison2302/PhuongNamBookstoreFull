package com.hungviet.phuongnambookstore.Activity.Create_Accout;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.Activity.Sach.HomeActivity;
import com.hungviet.phuongnambookstore.R;

public class TaoTaiKhoan5Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_tai_khoan5);
        Drawable drawable= getResources().getDrawable(R.drawable.close);
//...
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    public void dangky(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialog  = LayoutInflater.from(this).inflate(R.layout.giaodien,null);
        builder.setView(dialog);

        builder.create();
        builder.show();

        openActivity(HomeActivity.class);

    }
}
