package com.hungviet.phuongnambookstore.Activity.Top_Ban_Chay;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.BaseActivity;

public class Them_Top_SachActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them__top__sach);
        Drawable drawable= getResources().getDrawable(R.drawable.close);
//...
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    public void openActivityy(View view) {
        openActivity(Top_Ban_ChayActivity.class);
    }
}
