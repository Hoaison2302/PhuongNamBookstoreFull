package com.hungviet.phuongnambookstore.Activity.Create_Accout;

import androidx.annotation.NonNull;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.R;

public class TaoTaiKhoan1Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taotaikhoan1activity);
        Drawable drawable= getResources().getDrawable(R.drawable.close);
//...
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.next:
                openActivity(TaoTaiKhoan2Activity.class);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.next,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
