package com.hungviet.phuongnambookstore.Activity.Login_To_Facebook;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.Activity.Sach.HomeActivity;
import com.hungviet.phuongnambookstore.R;

public class Login_to_facebookActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to_facebook);

        Drawable drawable= getResources().getDrawable(R.drawable.close);
//...
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    public void Continus(View view) {
        openActivity(HomeActivity.class);
    }
}
