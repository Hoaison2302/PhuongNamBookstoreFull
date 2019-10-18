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
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_Ban_Dao;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_NhapActivity;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_Nhap_Dao;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Nhap;

import java.util.Calendar;
import java.util.List;

public class Hoa_Don_NhapAdapter extends RecyclerView.Adapter<Hoa_Don_NhapAdapter.HoaDonHolder> {
    private List<Hoa_Don_Nhap> hoa_don_nhapList;
    private Context context;
    AlertDialog alertDialog;
    Hoa_Don_Nhap hoa_don_nhap1;
    private Hoa_Don_Nhap_Dao hoa_don_nhap_dao;

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
    public void onBindViewHolder(@NonNull final HoaDonHolder holder, final int position) {
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
                final Button ok,cancel;
                ok=dialog.findViewById(R.id.btnallow);
                cancel=dialog.findViewById(R.id.btncancel);

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hoa_don_nhap_dao = new Hoa_Don_Nhap_Dao(context);

                        hoa_don_nhap_dao.deleteUser(hoa_don_nhapList.get(position).mahoadonnhap);
                        notifyDataSetChanged();
                        hoa_don_nhapList.remove(position);
                        alertDialog.dismiss();

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

        holder.iv_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View dialog  = LayoutInflater.from(context).inflate(R.layout.them_hoa_don_nhap,null);
                builder.setView(dialog);


                ImageView btnngay;

                final TextInputEditText edttheloai,edttensach,edtgia,edtsoluong,edtmasach,edtngay;
                final Button ok,cancel;
                edtngay=dialog.findViewById(R.id.edtngay);
                btnngay=dialog.findViewById(R.id.btnngay);
                ok=dialog.findViewById(R.id.btnok);
                cancel=dialog.findViewById(R.id.btncancel);

                edttheloai=dialog.findViewById(R.id.edttheloai);
                edttensach=dialog.findViewById(R.id.edttensach);
                edtgia=dialog.findViewById(R.id.edtgia);
                edtsoluong=dialog.findViewById(R.id.edtsoluong);
                edtmasach=dialog.findViewById(R.id.edtmasach);

                edtmasach.setText(hoa_don_nhapList.get(position).getMahoadonnhap());



                btnngay.setOnClickListener(new View.OnClickListener() {
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
                            Toast.makeText(context,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else if (tensach.equals("")){
                            Toast.makeText(context,"Vui Lòng Nhập Tên Sách!",Toast.LENGTH_SHORT).show();
                        }else if (ngaynhap.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else if (soluong.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else if (gianhap.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else if (mahoadonnhap.equalsIgnoreCase("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else {

                            hoa_don_nhap_dao =new Hoa_Don_Nhap_Dao(context);

                            hoa_don_nhap1=new Hoa_Don_Nhap();

                            hoa_don_nhap1.setTheloai(edttheloai.getText().toString().trim());
                            hoa_don_nhap1.setTensach(edttensach.getText().toString().trim());
                            hoa_don_nhap1.setSoluong(edtsoluong.getText().toString().trim());
                            hoa_don_nhap1.setGianhap(edtgia.getText().toString().trim()+"");
                            hoa_don_nhap1.setNgaynhap(edtngay.getText().toString().trim());
                            hoa_don_nhap1.setMahoadonnhap(edtmasach.getText().toString().trim());


                            long resurt = hoa_don_nhap_dao.updateUser(hoa_don_nhap1);
                            if(resurt>0){
                                Toast.makeText(context,"Sửa Thành Công",Toast.LENGTH_SHORT).show();

                                alertDialog.dismiss();
                                Intent intent
                                        =new Intent(context,Hoa_Don_NhapActivity.class);
                                context.startActivity(intent);
                            }else {
                                Toast.makeText(context,"Sửa Thất Bại!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });



                builder.create();
                alertDialog=builder.show();
            }
        });






    }

    @Override
    public int getItemCount() {
        return hoa_don_nhapList.size();
    }



    public class HoaDonHolder extends RecyclerView.ViewHolder {
        private TextView tvtheloai,tvtensach,tvngaynhap,tvsoluongnhap,tvgianhap;
        private ImageView imageView,iv_sua;


        public HoaDonHolder(@NonNull View itemView) {
            super(itemView);

            tvtheloai=itemView.findViewById(R.id.tvtheloai);
            tvgianhap=itemView.findViewById(R.id.tvgianhap);
            tvngaynhap=itemView.findViewById(R.id.tvngaynhap);
            tvsoluongnhap=itemView.findViewById(R.id.tvsoluongnhap);
            tvtensach=itemView.findViewById(R.id.tvtensach);
            imageView = itemView.findViewById(R.id.ivthungrac_hoadonnhap);
            iv_sua=itemView.findViewById(R.id.iv_sua);

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
