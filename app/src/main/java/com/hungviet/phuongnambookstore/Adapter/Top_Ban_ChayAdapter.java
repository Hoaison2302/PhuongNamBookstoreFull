package com.hungviet.phuongnambookstore.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.Top_Ban_Chay;

import java.util.List;

public class Top_Ban_ChayAdapter extends RecyclerView.Adapter<Top_Ban_ChayAdapter.Top_Ban_ChayHolder> {
    private List<Top_Ban_Chay> topBanChayList;
    private Context context;


    public Top_Ban_ChayAdapter(List<Top_Ban_Chay> topBanChayList, Context context) {
        this.topBanChayList = topBanChayList;
        this.context = context;
    }
    @NonNull
    @Override
    public Top_Ban_ChayHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_ban_chay_item,viewGroup,false);
        return new Top_Ban_ChayHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull Top_Ban_ChayHolder holder, int position) {

        holder.tvten.setText(topBanChayList.get(position).name);
        holder.tvgia.setText(topBanChayList.get(position).giaban);
        holder.tvtheloai.setText(topBanChayList.get(position).theloai);
        holder.ivluachon.setImageResource(topBanChayList.get(position).luachon);
        holder.ivanh.setImageResource(topBanChayList.get(position).anh);




    }

    @Override
    public int getItemCount() {
        return topBanChayList.size();
    }

    public class Top_Ban_ChayHolder extends RecyclerView.ViewHolder {
        private ImageView ivanh,ivluachon;
        private TextView tvtheloai,tvten,tvgia;
        public Top_Ban_ChayHolder(@NonNull View itemView) {
            super(itemView);
            ivanh=itemView.findViewById(R.id.imAnh);
            ivluachon = itemView.findViewById(R.id.ivluachon);
            tvtheloai = itemView.findViewById(R.id.tv_theloai);
            tvten = itemView.findViewById(R.id.tvten_sach_ban_chay);
            tvgia = itemView.findViewById(R.id.tvgia_top);


        }
    }
}
