package com.hungviet.phuongnambookstore.Activity.Top_Ban_Chay;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hungviet.phuongnambookstore.Adapter.Top_Ban_ChayAdapter;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.BaseActivity;
import com.hungviet.phuongnambookstore.model.Top_Ban_Chay;

import java.util.ArrayList;
import java.util.List;

public class Top_Ban_ChayActivity extends BaseActivity {
    private RecyclerView recyclerVieww;
    private List<Top_Ban_Chay> topBanChayList;
    private Top_Ban_ChayAdapter top_ban_chayAdapter;
    private FloatingActionButton floatingActionButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top__ban__chay);
        recyclerVieww=findViewById(R.id.rc_sachbanchay);
        floatingActionButton5=findViewById(R.id.floatingActionButton5);
        Drawable drawable= getResources().getDrawable(R.drawable.pri);
//...
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        topBanChayList =new ArrayList<>();

        topBanChayList.add(new Top_Ban_Chay("Nghệ Thuật Đàm Phán","Thể loại: Kỹ năng nói chuyện","Giá bán: 890 $",R.drawable.luachon,R.drawable.nghethuatdamphan));
        topBanChayList.add(new Top_Ban_Chay("Nghệ Thuật Đàm Phán","Thể loại: Kỹ năng nói chuyện","Giá bán: 890 $",R.drawable.luachon,R.drawable.nghethuatdamphan));
        topBanChayList.add(new Top_Ban_Chay("Nghệ Thuật Đàm Phán","Thể loại: Kỹ năng nói chuyện","Giá bán: 890 $",R.drawable.luachon,R.drawable.nghethuatdamphan));
        topBanChayList.add(new Top_Ban_Chay("Nghệ Thuật Đàm Phán","Thể loại: Kỹ năng nói chuyện","Giá bán: 890 $",R.drawable.luachon,R.drawable.nghethuatdamphan));
        topBanChayList.add(new Top_Ban_Chay("Nghệ Thuật Đàm Phán","Thể loại: Kỹ năng nói chuyện","Giá bán: 890 $",R.drawable.luachon,R.drawable.nghethuatdamphan));
        topBanChayList.add(new Top_Ban_Chay("Nghệ Thuật Đàm Phán","Thể loại: Kỹ năng nói chuyện","Giá bán: 890 $",R.drawable.luachon,R.drawable.nghethuatdamphan));





        top_ban_chayAdapter = new Top_Ban_ChayAdapter(topBanChayList,this);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerVieww.setLayoutManager(gridLayoutManager);
        recyclerVieww.setAdapter(top_ban_chayAdapter);




        floatingActionButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Them_Top_SachActivity.class);
            }
        });
    }
}
