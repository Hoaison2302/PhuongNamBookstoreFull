package com.hungviet.phuongnambookstore.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_BanActivity;
import com.hungviet.phuongnambookstore.Activity.Hoa_Don.Hoa_Don_Ban_Dao;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin_Nguoi_Dung.NguoiDungDao;
import com.hungviet.phuongnambookstore.Activity.Thong_Tin_Nguoi_Dung.Thong_Tin_Nguoi_DungActivity;
import com.hungviet.phuongnambookstore.R;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Ban;
import com.hungviet.phuongnambookstore.model.Person;

import java.util.List;

public class Nguoi_DungAdapter extends RecyclerView.Adapter<Nguoi_DungAdapter.NguoiDung_Adapter> {

    private List<Person> personList;
    private Context context;
    private NguoiDungDao nguoiDungDao;
    Person person;
    AlertDialog alertDialog;

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
    public void onBindViewHolder(@NonNull final NguoiDung_Adapter holder, final int position) {
        holder.email.setText(personList.get(position).email);
//        holder.kechan.setImageResource(personList.get(position).kechan);
//        holder.thucrac.setImageResource(personList.get(position).thucrac);
//        holder.custom.setImageResource(personList.get(position).custom);



        holder.thucrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button ok,cancel;

                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final View dialog  = LayoutInflater.from(context).inflate(R.layout.xoa_nguoi_dung_dialog,null);
                builder.setView(dialog);

                ok=dialog.findViewById(R.id.btnallow);
                cancel=dialog.findViewById(R.id.btncancel);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nguoiDungDao = new NguoiDungDao(context);
                        nguoiDungDao.deleteUser(personList.get(position).getManguoidung());
                        notifyDataSetChanged();
                        personList.remove(position);
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
        holder.custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View dialog  = LayoutInflater.from(context).inflate(R.layout.sua_nguoi_dung,null);
                builder.setView(dialog);
                final TextInputEditText email,hoten,matkhau,sdt,manguoidung;
                final Button oki,cen;
                oki =dialog.findViewById(R.id.ok_nguoidung);
                cen=dialog.findViewById(R.id.cen_nguoidung);


                email=dialog.findViewById(R.id.email_nguoidung);
                hoten=dialog.findViewById(R.id.hoten_nguoidung);
                matkhau=dialog.findViewById(R.id.matkhau_nguoidung);
                manguoidung=dialog.findViewById(R.id.ma_nguoidung);
                sdt=dialog.findViewById(R.id.sdt_nguoidung);

                manguoidung.setText(personList.get(position).getManguoidung());

                oki.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                        String theloai = email.getText().toString().trim();
                        String tensach = hoten.getText().toString().trim();
                        String soluong = matkhau.getText().toString().trim();
                        String gianhap = sdt.getText().toString().trim();
                        String ngaynhap = manguoidung.getText().toString().trim();





                        if (theloai.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else if (tensach.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else if (ngaynhap.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else if (gianhap.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else if (soluong.equals("")){
                            Toast.makeText(context,"Vui Lòng Không Để Trống Thông Tin!",Toast.LENGTH_SHORT).show();
                        }else {

                            person =new Person();
                            nguoiDungDao = new NguoiDungDao(context);


                            person.setEmail(email.getText().toString().trim());
                            person.setHoten(hoten.getText().toString().trim());
                            person.setMatkhau(matkhau.getText().toString().trim());
                            person.setSdt(sdt.getText().toString().trim());
                            person.setManguoidung(manguoidung.getText().toString().trim());



                            long resurt = nguoiDungDao.updateUser(person);
                            if(resurt>0){
                                Toast.makeText(context,"Update Thành Công!",Toast.LENGTH_SHORT).show();
                                alertDialog.dismiss();
                                Intent intent
                                        =new Intent(context, Thong_Tin_Nguoi_DungActivity.class);
                                context.startActivity(intent);

                            }else {
                                Toast.makeText(context,"Update Thất Bại!",Toast.LENGTH_SHORT).show();
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
