package com.hungviet.phuongnambookstore.Activity.Thong_Tin_Nguoi_Dung;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hungviet.phuongnambookstore.Activity.Create_Accout.TaoTaiKhoan1Activity;
import com.hungviet.phuongnambookstore.Adapter.Nguoi_DungAdapter;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Thong_Tin_Nguoi_DungActivity extends BaseActivity {

    private RecyclerView recyclerView_Thong_tin_nguoi_dung;
    private List<Person> personList;
    private FloatingActionButton floatingActionButton;

    private Nguoi_DungAdapter nguoiDung_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong__tin__nguoi__dung);
        recyclerView_Thong_tin_nguoi_dung= findViewById(R.id.rcthong_tin_nguoi_dung);
        floatingActionButton = findViewById(R.id.floatingActionButton3);

        Drawable drawable= getResources().getDrawable(R.drawable.pri);
//...
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);





        personList = new ArrayList<>();

        personList.add(new Person("hungdieu182@gmail.com",null,null,null,R.drawable.kechan,R.drawable.custom,R.drawable.thungrac));
        personList.add(new Person("hungdieu182@gmail.com",null,null,null,R.drawable.kechan,R.drawable.custom,R.drawable.thungrac));
        personList.add(new Person("hungdieu182@gmail.com",null,null,null,R.drawable.kechan,R.drawable.custom,R.drawable.thungrac));
        personList.add(new Person("hungdieu182@gmail.com",null,null,null,R.drawable.kechan,R.drawable.custom,R.drawable.thungrac));
        personList.add(new Person("hungdieu182@gmail.com",null,null,null,R.drawable.kechan,R.drawable.custom,R.drawable.thungrac));
        personList.add(new Person("hungdieu182@gmail.com",null,null,null,R.drawable.kechan,R.drawable.custom,R.drawable.thungrac));
        personList.add(new Person("hungdieu182@gmail.com",null,null,null,R.drawable.kechan,R.drawable.custom,R.drawable.thungrac));




        nguoiDung_adapter = new Nguoi_DungAdapter(personList,this);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView_Thong_tin_nguoi_dung.setLayoutManager(gridLayoutManager);
        recyclerView_Thong_tin_nguoi_dung.setAdapter(nguoiDung_adapter);




        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(TaoTaiKhoan1Activity.class);
            }
        });
    }
}
