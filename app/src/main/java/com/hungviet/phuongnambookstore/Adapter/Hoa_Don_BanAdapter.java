package com.hungviet.phuongnambookstore.Adapter;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_BanActivity;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_Ban_Dao;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_NhapActivity;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_Nhap_Dao;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Ban;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Nhap;

import java.util.Calendar;
import java.util.List;

public class Hoa_Don_BanAdapter extends RecyclerView.Adapter<Hoa_Don_BanAdapter.HoadonbanHolder> {
    private List<Hoa_Don_Ban> hoa_don_banList;
    private Context context;
    private Hoa_Don_Ban_Dao hoa_don_ban_dao;
    private AlertDialog alertDialog;
    Hoa_Don_Ban hoa_don_ban;

    public Hoa_Don_BanAdapter(List<Hoa_Don_Ban> hoa_don_banList, Context context) {
        this.hoa_don_banList = hoa_don_banList;
        this.context = context;
    }

    @NonNull
    @Override
    public Hoa_Don_BanAdapter.HoadonbanHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hoadon_ban,viewGroup,false);
        return new Hoa_Don_BanAdapter.HoadonbanHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Hoa_Don_BanAdapter.HoadonbanHolder holder, final int position) {
        holder.tvtensach.setText(hoa_don_banList.get(position).getTensach());
        holder.tvgianhap.setText(String.valueOf(hoa_don_banList.get(position).getGiaban()+" $"));
        holder.tvsoluongnhap.setText(String.valueOf(hoa_don_banList.get(position).getSoluongban()+" Cuốn"));
        holder.tvtheloai.setText(hoa_don_banList.get(position).getTheloai());
        holder.tvngaynhap.setText(hoa_don_banList.get(position).getNgayban());


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
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
                        alertDialog.dismiss();


                    }
                });

                builder.create();
               alertDialog = builder.show();
            }
        });


        holder.sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View dialog  = LayoutInflater.from(context).inflate(R.layout.them_hoa_don_ban,null);
                builder.setView(dialog);


                final TextInputEditText edttheloai,edttensach,edtgia,edtsoluong,edtmasach,edtngay;
                final Button ok,cancel;
                final ImageView ngay;

                edtngay=dialog.findViewById(R.id.edtngayi);
                ok=dialog.findViewById(R.id.btnoki);
                cancel=dialog.findViewById(R.id.btncanceli);



                edttheloai=dialog.findViewById(R.id.edttheloaii);
                edttensach=dialog.findViewById(R.id.edttensachi);
                edtgia=dialog.findViewById(R.id.edtgiai);
                edtsoluong=dialog.findViewById(R.id.edtsoluongi);
                edtmasach=dialog.findViewById(R.id.edtmasachi);

                edtngay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Calendar calendar=Calendar.getInstance(); //khoi tao
                        int nam=calendar.get(Calendar.YEAR);  //thiet lap ngay thang nam
                        int thang=calendar.get(Calendar.MONTH);  //thiet lap ngay thang nam
                        int ngay=calendar.get(Calendar.DAY_OF_MONTH);  //thiet lap ngay thang nam
                        DatePickerDialog dialog=new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                edtngay.setText(view.getDayOfMonth()+"/"+(view.getMonth()+1)+"/"+view.getYear());

                            }
                        },nam,thang,ngay);
                        dialog.show();
                    }
                });

                edttheloai.setText(hoa_don_banList.get(position).getTheloai());
                edttensach.setText(hoa_don_banList.get(position).getTensach());
                edtngay.setText(hoa_don_banList.get(position).getNgayban());
                edtgia.setText(String.valueOf(hoa_don_banList.get(position).getGiaban()));
                edtsoluong.setText(String.valueOf(hoa_don_banList.get(position).getSoluongban()));
                edtmasach.setText(hoa_don_banList.get(position).getMahoadonban());


                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                        String theloai = edttheloai.getText().toString().trim();
                        String tensach = edttensach.getText().toString().trim();
                        String soluong = edtsoluong.getText().toString().trim();
                        String gianhap = edtgia.getText().toString().trim();
                        String ngaynhap = edtngay.getText().toString().trim();
                        String mahoadonnhap = edtmasach.getText().toString().trim();



                        if (theloai.equals("")){
                            Toast.makeText(context,"Vui Lòng Nhập Thể Loại!",Toast.LENGTH_SHORT).show();
                        }else if (tensach.equals("")){
                            Toast.makeText(context,"Vui Lòng Nhập Tên Sách!",Toast.LENGTH_SHORT).show();
                        }else if (ngaynhap.equals("")){
                            Toast.makeText(context,"Vui Lòng Nhập Ngày!",Toast.LENGTH_SHORT).show();
                        }else if (gianhap.equals("")){
                            Toast.makeText(context,"Vui Lòng Nhập Giá!",Toast.LENGTH_SHORT).show();
                        }else if (soluong.equals("")){
                            Toast.makeText(context,"Vui Lòng Nhập Số Lượng!",Toast.LENGTH_SHORT).show();
                        }else if (mahoadonnhap.equalsIgnoreCase("")){
                            Toast.makeText(context,"Vui Lòng Nhập Mã Hóa Đơn!",Toast.LENGTH_SHORT).show();
                        }else {

                            hoa_don_ban_dao =new Hoa_Don_Ban_Dao(context);

                            hoa_don_ban=new Hoa_Don_Ban();

                            hoa_don_ban.setTheloai(edttheloai.getText().toString().trim());
                            hoa_don_ban.setTensach(edttensach.getText().toString().trim());
                            hoa_don_ban.setSoluongban(Integer.parseInt(edtsoluong.getText().toString().trim()));
                            hoa_don_ban.setGiaban(Integer.parseInt(edtgia.getText().toString().trim()+""));
                            hoa_don_ban.setNgayban(edtngay.getText().toString().trim());
                            hoa_don_ban.setMahoadonban(edtmasach.getText().toString().trim());


                            long resurt = hoa_don_ban_dao.updateUser(hoa_don_ban);
                            if(resurt>0){
                                Toast.makeText(context,"Thêm dc",Toast.LENGTH_SHORT).show();
                                alertDialog.dismiss();
                                Intent intent
                                        =new Intent(context, Hoa_Don_BanActivity.class);
                                context.startActivity(intent);

                                notifyDataSetChanged();
                            }else {
                                Toast.makeText(context,"Thêm 0 dc",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });



                builder.create();
                alertDialog=builder.show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return hoa_don_banList.size();
    }

    public class HoadonbanHolder extends RecyclerView.ViewHolder {
        private TextView tvtheloai,tvtensach,tvngaynhap,tvsoluongnhap,tvgianhap;
        private ImageView imageView,sua;

        public HoadonbanHolder(@NonNull View itemView) {
            super(itemView);


            tvtheloai=itemView.findViewById(R.id.tvtheloaii);
            tvgianhap=itemView.findViewById(R.id.tvgianhapi);
            tvngaynhap=itemView.findViewById(R.id.tvngaynhapi);
            tvsoluongnhap=itemView.findViewById(R.id.tvsoluongnhapi);
            tvtensach=itemView.findViewById(R.id.tvtensachi);
            imageView=itemView.findViewById(R.id.ivthungrac_hoadonnhapi);
            sua=itemView.findViewById(R.id.iv_suai);
        }
    }
}
