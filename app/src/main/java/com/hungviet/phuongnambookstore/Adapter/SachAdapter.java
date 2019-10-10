package com.hungviet.phuongnambookstore.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hungviet.phuongnambookstore.Activity.Sach.Sua_SachActivity;
import com.hungviet.phuongnambookstore.Activity.Sach.Them_SachActivity;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.Sach;

import java.util.List;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.SachHolder> {
    private List<Sach> sachList;
    private Context context;

    public SachAdapter(List<Sach> sachList, Context context) {
        this.sachList = sachList;
        this.context = context;
    }

    @NonNull
    @Override
    public SachHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sachitem,viewGroup,false);
        return new SachHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SachHolder holder, int position) {
        holder.tvten.setText(sachList.get(position).ten);
        holder.tvtacgia.setText(sachList.get(position).tacgia);
        holder.tvgia.setText(sachList.get(position).gia);
        holder.tvluotxem.setText(sachList.get(position).luotxem);
        holder.anh.setImageResource(sachList.get(position).anh);
        holder.view.setImageResource(sachList.get(position).view);
        holder.luachon.setImageResource(sachList.get(position).luachon);

        holder.luachon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,v);
                popupMenu.getMenuInflater().inflate(R.menu.pocup_sua_xoa, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.pocup_xoa:
                                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                final View dialog  = LayoutInflater.from(context).inflate(R.layout.xoa_dau_sach_dialog,null);
                                builder.setView(dialog);

                                builder.create();
                                builder.show();


                            Button btnAllow,btncancel;
                            btnAllow = dialog.findViewById(R.id.btnallow);
                            btncancel=dialog.findViewById(R.id.btncancel);



                            btnAllow.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(context,"Đã Xóa!",Toast.LENGTH_SHORT).show();

                                }
                            });
                                btncancel.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(context,"Không Xóa!",Toast.LENGTH_SHORT).show();
                                    }
                                });
                                break;

                            case R.id.pocup_sua:
                                Intent intent = new Intent(context, Sua_SachActivity.class);
                                context.startActivity(intent);
                                break;


                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });









    }

    @Override
    public int getItemCount() {
        return sachList.size();
    }

    public class SachHolder extends RecyclerView.ViewHolder {
        private TextView tvten,tvtacgia,tvgia,tvluotxem;
        public ImageView anh,view,luachon;

        public SachHolder(@NonNull View itemView) {
            super(itemView);
            tvten=itemView.findViewById(R.id.tvten);
            tvtacgia=itemView.findViewById(R.id.tvtacgia);
            tvgia=itemView.findViewById(R.id.tvgia);
            tvluotxem=itemView.findViewById(R.id.tvluotxem);
            anh = itemView.findViewById(R.id.imageView2);
            view = itemView.findViewById(R.id.tvview);
            luachon = itemView.findViewById(R.id.tvluachon);
        }
    }
}
