package com.hungviet.phuongnambookstore.Activity.Hoa_Don;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hungviet.phuongnambookstore.Activity.Sach.SachSqlite;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Nhap;
import com.hungviet.phuongnambookstore.model.Sach.Sach;


import java.util.ArrayList;
import java.util.List;

public class Hoa_Don_Nhap_Dao {
    private SachSqlite sachSqlite;

    public Hoa_Don_Nhap_Dao(Context context) {
        this.sachSqlite = new SachSqlite(context);
    }

    private String USER_TABLE = "hoadonnhap";

    public String THELOAI = "theloai";
    public String TENSACH = "tensach";
    public String NGAYNHAP = "ngaynhap";
    public String SOLUONG = "soluong";
    public String GIANHAP = "giaban";
    public String MAHOADONNHAP = "mahoadonnhap";



    public List<Hoa_Don_Nhap> getAll() {
        List<Hoa_Don_Nhap> hoa_don_nhapList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = sachSqlite.getReadableDatabase();

        String SQL = "SELECT * FROM " + USER_TABLE ;
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Hoa_Don_Nhap hoa_don_nhap = new Hoa_Don_Nhap();

                    hoa_don_nhap.setTheloai(cursor.getString(cursor.getColumnIndex(THELOAI)));
                    hoa_don_nhap.setTensach(cursor.getString(cursor.getColumnIndex(TENSACH)));
                    hoa_don_nhap.setNgaynhap(cursor.getString(cursor.getColumnIndex(NGAYNHAP)));
                    hoa_don_nhap.setSoluong(cursor.getInt(cursor.getColumnIndex(SOLUONG)));
                    hoa_don_nhap.setGianhap(cursor.getInt(cursor.getColumnIndex(GIANHAP)));
                    hoa_don_nhap.setMahoadonnhap(cursor.getString(cursor.getColumnIndex(MAHOADONNHAP)));

                    hoa_don_nhapList.add(hoa_don_nhap);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return hoa_don_nhapList;
    }
//    public long insertUser(Hoa_Don_Ban hoa_don_ban) {
//        SQLiteDatabase sqLiteDatabase = sachSqlite.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(THELOAI, hoa_don_ban.getTheloai());
//        contentValues.put(TENSACH, hoa_don_ban.getTensach());
//        contentValues.put(GIABAN, hoa_don_ban.getGiaban());
//        contentValues.put(SOLUONGBAN,hoa_don_ban.getSoluongban());
//        contentValues.put(MAHOADONBAN,hoa_don_ban.getMahoadonban());
//
//
//        long result = sqLiteDatabase.insert(USER_TABLE, null, contentValues);
//        sqLiteDatabase.close();
//        return result;
//    }
//
//    public long updateUser(Hoa_Don_Ban hoa_don_ban) {
//        SQLiteDatabase sqLiteDatabase = sachSqlite.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(THELOAI, hoa_don_ban.getTheloai());
//        contentValues.put(TENSACH, hoa_don_ban.getTensach());
//        contentValues.put(GIABAN, hoa_don_ban.getGiaban());
//        contentValues.put(SOLUONGBAN,hoa_don_ban.getSoluongban());
//        contentValues.put(MAHOADONBAN,hoa_don_ban.getMahoadonban());
//
//        long result = sqLiteDatabase.update(USER_TABLE,contentValues, TENSACH + "=?", new String[]{hoa_don_ban.getMahoadonban()});
//        sqLiteDatabase.close();
//        return result;
//    }
//    public void deleteUser(String id) {
//        SQLiteDatabase sqLiteDatabase = sachSqlite.getWritableDatabase();
//
//        sqLiteDatabase.delete(USER_TABLE, MAHOADONBAN + "=?", new String[]{id});
//
//    }

}
