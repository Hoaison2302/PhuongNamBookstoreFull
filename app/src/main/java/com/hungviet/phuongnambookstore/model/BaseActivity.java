package com.hungviet.phuongnambookstore.model;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void openActivity(Class activity){
        Intent intent = new Intent(this,activity);
        startActivity(intent);

    }
}
