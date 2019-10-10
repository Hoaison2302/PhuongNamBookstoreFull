package com.hungviet.phuongnambookstore.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.hungviet.phuongnambookstore.Activity.Create_Accout.TaoTaiKhoan1Activity;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_NhapActivity;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.Person;
import com.hungviet.phuongnambookstore.model.Sach;

import java.util.List;

public class Nguoi_DungAdapter extends RecyclerView.Adapter<Nguoi_DungAdapter.NguoiDung_Adapter> {

    private List<Person> personList;
    private Context context;

    public Nguoi_DungAdapter(List<Person> personList, Context context) {
        this.personList = personList;
        this.context = context;
    }

    @NonNull
    @Override
    public NguoiDung_Adapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nguoidung_item,viewGroup,false);
        return new NguoiDung_Adapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NguoiDung_Adapter holder, int position) {
        holder.email.setText(personList.get(position).Email);
        holder.kechan.setImageResource(personList.get(position).kechan);
        holder.thucrac.setImageResource(personList.get(position).thucrac);
        holder.custom.setImageResource(personList.get(position).custom);



        holder.thucrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View dialog  = LayoutInflater.from(context).inflate(R.layout.xoa_nguoi_dung_dialog,null);
                builder.setView(dialog);

                builder.create();
                builder.show();
            }
        });
        holder.custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View dialog  = LayoutInflater.from(context).inflate(R.layout.sua_nguoi_dung,null);
                builder.setView(dialog);

                builder.create();
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class NguoiDung_Adapter extends RecyclerView.ViewHolder {
        private ImageView thucrac,custom,kechan;
        private TextView email;
        public NguoiDung_Adapter(@NonNull View itemView) {
            super(itemView);
            thucrac=itemView.findViewById(R.id.ivthungrac);
            custom=itemView.findViewById(R.id.ivcustom);
            kechan=itemView.findViewById(R.id.ivkechan);
            email=itemView.findViewById(R.id.tvMail);
        }
    }
}
