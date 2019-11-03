package com.hungviet.phuongnambookstore.Activity.Top_Ban_Chay;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.hungviet.phuongnambookstore.Activity.Sach.HomeActivity;
import com.hungviet.phuongnambookstore.Activity.Sach.Them_SachActivity;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.model.Sach.Sach;

public class Them_Top_SachActivity extends BaseActivity {
    TextInputEditText ten,theloai,soluong,masach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them__top__sach);
        ten=findViewById(R.id.tensach);
        theloai=findViewById(R.id.theloai);
        soluong=findViewById(R.id.soluong);
        masach=findViewById(R.id.masach);

        Drawable drawable= getResources().getDrawable(R.drawable.close);
//...
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    public void openActivityy(View view) {
        openActivity(Top_Ban_ChayActivity.class);
        Toast.makeText(this,"Thêm thành công!",Toast.LENGTH_SHORT).show();
    }
}
