package com.hungviet.phuongnambookstore.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Nhap;

import java.util.List;

public class Hoa_Don_NhapAdapter extends RecyclerView.Adapter<Hoa_Don_NhapAdapter.HoaDonHolder> {
    private List<Hoa_Don_Nhap> hoa_don_nhapList;
    private Context context;

    public Hoa_Don_NhapAdapter(List<Hoa_Don_Nhap> hoa_don_nhapList, Context context) {
        this.hoa_don_nhapList = hoa_don_nhapList;
        this.context = context;
    }

    @NonNull
    @Override
    public Hoa_Don_NhapAdapter.HoaDonHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hoadon_nhap,viewGroup,false);
        return new Hoa_Don_NhapAdapter.HoaDonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HoaDonHolder holder, int position) {
        holder.tvtensach.setText(hoa_don_nhapList.get(position).getTensach());
        holder.tvgianhap.setText(hoa_don_nhapList.get(position).getGianhap());
        holder.tvsoluongnhap.setText(hoa_don_nhapList.get(position).getSoluong());
        holder.tvtheloai.setText(hoa_don_nhapList.get(position).getTheloai());
        holder.tvngaynhap.setText(hoa_don_nhapList.get(position).getNgaynhap());





        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View dialog  = LayoutInflater.from(context).inflate(R.layout.xoa_hoa_don_dialog,null);
                builder.setView(dialog);

                builder.create();
                builder.show();
            }
        });






    }

    @Override
    public int getItemCount() {
        return hoa_don_nhapList.size();
    }



    public class HoaDonHolder extends RecyclerView.ViewHolder {
        private TextView tvtheloai,tvtensach,tvngaynhap,tvsoluongnhap,tvgianhap;
        private ImageView imageView;


        public HoaDonHolder(@NonNull View itemView) {
            super(itemView);

            tvtheloai=itemView.findViewById(R.id.tvtheloai);
            tvgianhap=itemView.findViewById(R.id.tvgianhap);
            tvngaynhap=itemView.findViewById(R.id.tvngaynhap);
            tvsoluongnhap=itemView.findViewById(R.id.tvsoluongnhap);
            tvtensach=itemView.findViewById(R.id.tvtensach);
            imageView = itemView.findViewById(R.id.ivthungrac_hoadonnhap);


        }
    }
}



















//    private List<Hoa_Don_Nhap> hoa_don_nhapList;
//    private Context context;
//
//    public Hoa_Don_NhapAdapter(List<Hoa_Don_Nhap> hoa_don_nhapList, Context context) {
//        this.hoa_don_nhapList = hoa_don_nhapList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public Ho onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hoadon_nhap,viewGroup,false);
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull HoadonnhapHolder holder, int position) {
//        holder.tvtensach.setText(hoa_don_nhapList.get(position).tensach);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return hoa_don_nhapList.size();
//    }
//
//
//
//public class HoadonnhapHolder extends RecyclerView.ViewHolder {
//    private TextView tvtheloai,tvtensach,tvngaynhap,tvsoluongnhap,tvgianhap;
//    public HoadonnhapHolder(@NonNull View itemView) {
//        super(itemView);
//        tvtheloai=itemView.findViewById(R.id.tvtheloai);
//        tvgianhap=itemView.findViewById(R.id.tvgianhap);
//        tvngaynhap=itemView.findViewById(R.id.tvngaynhap);
//        tvsoluongnhap=itemView.findViewById(R.id.tvsoluongnhap);
//        tvtensach=itemView.findViewById(R.id.tvtensach);
//    }
//}
