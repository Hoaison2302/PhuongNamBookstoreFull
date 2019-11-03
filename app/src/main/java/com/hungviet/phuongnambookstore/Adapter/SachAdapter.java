package com.hungviet.phuongnambookstore.Adapter;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_NhapActivity;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_Nhap_Dao;
import com.hungviet.phuongnambookstore.Activity.Sach.HomeActivity;
import com.hungviet.phuongnambookstore.Activity.Sach.SachDao;
import com.hungviet.phuongnambookstore.Activity.Sach.Sua_SachActivity;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin_Nguoi_Dung.NguoiDungDao;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Nhap;
import com.hungviet.phuongnambookstore.model.Sach.Sach;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.SachHolder> {
    private List<Sach> sachList;
    private List<Sach> sachListfill;
    private Context context;
    private  Sach sachhhhh;
    SachDao sachDao;
    AlertDialog alertDialog;


    public SachAdapter(List<Sach> sachList, Context context,List<Sach> sachListfill) {
        this.sachList = sachList;
        this.context = context;
        this.sachListfill = sachListfill;
    }

    @NonNull
    @Override
    public SachHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sachitem,viewGroup,false);
        return new SachHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SachHolder holder, final int position) {
        holder.tvten.setText(sachList.get(position).getTen());
        holder.tvtacgia.setText(sachList.get(position).getTacgia());
        holder.tvgia.setText(sachList.get(position).getGia()+" $");
        holder.tvluotxem.setText(sachList.get(position).getLuotxem());




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
                                Button ok,cancel;

                                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                final View dialog  = LayoutInflater.from(context).inflate(R.layout.xoa_dau_sach_dialog,null);
                                builder.setView(dialog);

                                ok=dialog.findViewById(R.id.btnallow);
                                cancel=dialog.findViewById(R.id.btncancel);
                                ok.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {


                                        sachDao = new SachDao(context);
                                        sachDao.deleteUser(sachList.get(position).getMasach());
                                        sachList.remove(position);
                                        notifyDataSetChanged();
                                        alertDialog.dismiss();

                                    }
                                });

                                builder.create();
                                alertDialog=builder.show();

                            cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    alertDialog.dismiss();
                                }
                            });
                                break;



                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });





        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                View dialog1  = LayoutInflater.from(context).inflate(R.layout.sua_sach,null);
                builder1.setView(dialog1);




                final TextInputEditText edttensach_sach,edttacgia_sach,edtgia_sach,edtluotxem_sach,edtmasach_sach;
                final Button ok1,cancel1;
                ok1=dialog1.findViewById(R.id.btnok_sach);



                edttensach_sach=dialog1.findViewById(R.id.edttensach_sach);
                edttacgia_sach=dialog1.findViewById(R.id.edttacgia_sach);
                edtgia_sach=dialog1.findViewById(R.id.edtgia_sach);
                edtluotxem_sach=dialog1.findViewById(R.id.edtluotxem_sach);
                edtmasach_sach=dialog1.findViewById(R.id.edtmasach_sach);



                edttensach_sach.setText(sachList.get(position).getTen());
                edttacgia_sach.setText(sachList.get(position).getTacgia());
                edtgia_sach.setText(sachList.get(position).getGia());
                edtluotxem_sach.setText(sachList.get(position).getLuotxem());
                edtmasach_sach.setText(sachList.get(position).getMasach());



                ok1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                        String theloai = edttensach_sach.getText().toString().trim();
                        String tensach = edttacgia_sach.getText().toString().trim();
                        String soluong = edtgia_sach.getText().toString().trim();
                        String gianhap = edtluotxem_sach.getText().toString().trim();
                        String ngaynhap = edtmasach_sach.getText().toString().trim();


                        if (theloai.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Thể Loại!",Toast.LENGTH_SHORT).show();
                        }else if (tensach.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Tên Sách!",Toast.LENGTH_SHORT).show();
                        }else if (soluong.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Số Lượng!",Toast.LENGTH_SHORT).show();
                        }else if (gianhap.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Giá!",Toast.LENGTH_SHORT).show();
                        }else if (ngaynhap.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Ngày Nhập!",Toast.LENGTH_SHORT).show();
                        }else {


                            sachhhhh =new Sach();

                            sachhhhh.setTen(edttensach_sach.getText().toString().trim());
                            sachhhhh.setTacgia(edttacgia_sach.getText().toString().trim());
                            sachhhhh.setGia(edtgia_sach.getText().toString().trim());
                            sachhhhh.setLuotxem(edtluotxem_sach.getText().toString().trim());
                            sachhhhh.setMasach(edtmasach_sach.getText().toString().trim());


                            sachDao = new SachDao(context);

                            long resurt = sachDao.updateUser(sachhhhh);
                            if(resurt>0){
                                Toast.makeText(context,"Update Thành Công!",Toast.LENGTH_SHORT).show();

                                alertDialog.dismiss();
                                Intent intent
                                        =new Intent(context, HomeActivity.class);
                                context.startActivity(intent);


                            }else {
                                Toast.makeText(context,"Update Thất Bại!",Toast.LENGTH_SHORT).show();
                            }
                            notifyDataSetChanged();
                        }
                    }
                });



                builder1.create();
                alertDialog=builder1.show();
                return false;
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
    public Filter getFilter() {
        return qLnguoidungFilter;
    }

    private Filter qLnguoidungFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Sach> filteredlist=new ArrayList<>();

            if(constraint ==null || constraint.length()==0){
                filteredlist.addAll(sachListfill);
            }else {
                String filterPattern=constraint.toString().toLowerCase().trim();
                for (Sach item: sachListfill){
                    if (item.ten.toLowerCase().contains(filterPattern)){
                        filteredlist.add(item);
                    }
                }

            }

            FilterResults results=new FilterResults();
            results.values=filteredlist;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            sachList.clear();
            sachList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
