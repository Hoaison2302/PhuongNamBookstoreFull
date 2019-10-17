package com.hungviet.phuongnambookstore.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_Ban_Dao;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Ban;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Nhap;

import java.util.List;

public class Hoa_Don_BanAdapter extends RecyclerView.Adapter<Hoa_Don_BanAdapter.HoadonbanHolder> {
    private List<Hoa_Don_Ban> hoa_don_banList;
    private Context context;
    private Hoa_Don_Ban_Dao hoa_don_ban_dao;

    public Hoa_Don_BanAdapter(List<Hoa_Don_Ban> hoa_don_banList, Context context) {
        this.hoa_don_banList = hoa_don_banList;
        this.context = context;
    }

    @NonNull
    @Override
    public Hoa_Don_BanAdapter.HoadonbanHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hoadon_nhap,viewGroup,false);
        return new Hoa_Don_BanAdapter.HoadonbanHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Hoa_Don_BanAdapter.HoadonbanHolder holder, final int position) {
        holder.tvtensach.setText(hoa_don_banList.get(position).getTensach());
        holder.tvgianhap.setText(hoa_don_banList.get(position).getGiaban());
        holder.tvsoluongnhap.setText(hoa_don_banList.get(position).getSoluongban());
        holder.tvtheloai.setText(hoa_don_banList.get(position).getTheloai());
        holder.tvngaynhap.setText(hoa_don_banList.get(position).getNgayban()+"");


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View dialog  = LayoutInflater.from(context).inflate(R.layout.xoa_hoa_don_dialog,null);
                builder.setView(dialog);
                final Button ok,cancel;
                ok=dialog.findViewById(R.id.btnallow);
                cancel=dialog.findViewById(R.id.btncancel);

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hoa_don_ban_dao = new Hoa_Don_Ban_Dao(context);

                        hoa_don_ban_dao.deleteUser(hoa_don_banList.get(position).mahoadonban);
                        notifyDataSetChanged();
                        hoa_don_banList.remove(position);

                    }
                });

                builder.create();
                builder.show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return hoa_don_banList.size();
    }

    public class HoadonbanHolder extends RecyclerView.ViewHolder {
        private TextView tvtheloai,tvtensach,tvngaynhap,tvsoluongnhap,tvgianhap;
        private ImageView imageView;

        public HoadonbanHolder(@NonNull View itemView) {
            super(itemView);


            tvtheloai=itemView.findViewById(R.id.tvtheloai);
            tvgianhap=itemView.findViewById(R.id.tvgianhap);
            tvngaynhap=itemView.findViewById(R.id.tvngaynhap);
            tvsoluongnhap=itemView.findViewById(R.id.tvsoluongnhap);
            tvtensach=itemView.findViewById(R.id.tvtensach);
            imageView=itemView.findViewById(R.id.ivthungrac_hoadonnhap);
        }
    }
}
