package com.hungviet.phuongnambookstore.Activity.Lay_Lai_Tai_Khoan;

import androidx.annotation.NonNull;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.Activity.Sach.Welcome;
import com.hungviet.phuongnambookstore.R;

public class QuenMatKhau1Activity extends BaseActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quenmatkhau1activity);
        button = findViewById(R.id.button);
        Drawable drawable = getResources().getDrawable(R.drawable.close);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }


    public void lay_lai_mat_khau(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialog  = LayoutInflater.from(this).inflate(R.layout.giaodienquenmatkhau,null);
        builder.setView(dialog);

        Button lay_lai_mat_khau;
        lay_lai_mat_khau = dialog.findViewById(R.id.btnlay_lai_mat_khau);
        lay_lai_mat_khau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Welcome.class);
            }
        });

        builder.create();
        builder.show();



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }


}
