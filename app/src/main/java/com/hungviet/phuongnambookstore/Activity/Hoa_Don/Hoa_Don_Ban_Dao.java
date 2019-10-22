package com.hungviet.phuongnambookstore.Activity.Hoa_Don;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hungviet.phuongnambookstore.Activity.Sach.SachSqlite;
import com.hungviet.phuongnambookstore.model.Hoa_Don_Ban;
import com.hungviet.phuongnambookstore.model.Sach.Sach;

import java.util.ArrayList;
import java.util.List;

public class Hoa_Don_Ban_Dao {
    private SachSqlite sachSqlite;

    public Hoa_Don_Ban_Dao(Context context) {
        this.sachSqlite = new SachSqlite(context);
    }

    private String USER_TABLE = "hoadonban";

    public String THELOAI = "theloai";
    public String TENSACH = "tensach";
    public String NGAYBAN = "ngayban";
    public String SOLUONGBAN = "soluongban";
    public String GIABAN = "giaban";
    public String MAHOADONBAN = "mahoadonban";



    public List<Hoa_Don_Ban> getAll() {
        List<Hoa_Don_Ban> hoaDonBanList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = sachSqlite.getReadableDatabase();

        String SQL = "SELECT * FROM " + USER_TABLE ;

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Hoa_Don_Ban hoa_don_ban = new Hoa_Don_Ban();

                    hoa_don_ban.setTheloai(cursor.getString(cursor.getColumnIndex(THELOAI)));
                    hoa_don_ban.setTensach(cursor.getString(cursor.getColumnIndex(TENSACH)));
                    hoa_don_ban.setNgayban(cursor.getString(cursor.getColumnIndex(NGAYBAN)));
                    hoa_don_ban.setSoluongban(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SOLUONGBAN))));
                    hoa_don_ban.setGiaban(Integer.parseInt(cursor.getString(cursor.getColumnIndex(GIABAN))));
                    hoa_don_ban.setMahoadonban(cursor.getString(cursor.getColumnIndex(MAHOADONBAN)));


                    hoaDonBanList.add(hoa_don_ban);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return hoaDonBanList;
    }

    public long insertUser(Hoa_Don_Ban hoa_don_ban) {
        SQLiteDatabase sqLiteDatabase = sachSqlite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(THELOAI, hoa_don_ban.getTheloai());
        contentValues.put(TENSACH, hoa_don_ban.getTensach());
        contentValues.put(GIABAN, hoa_don_ban.getGiaban());
        contentValues.put(NGAYBAN, hoa_don_ban.getNgayban());
        contentValues.put(SOLUONGBAN,hoa_don_ban.getSoluongban());
        contentValues.put(MAHOADONBAN,hoa_don_ban.getMahoadonban());


        long result = sqLiteDatabase.insert(USER_TABLE, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public long updateUser(Hoa_Don_Ban hoa_don_ban) {
        SQLiteDatabase sqLiteDatabase = sachSqlite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(THELOAI, hoa_don_ban.getTheloai());
        contentValues.put(TENSACH, hoa_don_ban.getTensach());
        contentValues.put(GIABAN, hoa_don_ban.getGiaban());
        contentValues.put(NGAYBAN, hoa_don_ban.getNgayban());
        contentValues.put(SOLUONGBAN,hoa_don_ban.getSoluongban());
        contentValues.put(MAHOADONBAN,hoa_don_ban.getMahoadonban());

        long result = sqLiteDatabase.update(USER_TABLE,contentValues, MAHOADONBAN + "=?", new String[]{hoa_don_ban.getMahoadonban()});
        sqLiteDatabase.close();
        return result;
    }
    public void deleteUser(String id) {
        SQLiteDatabase sqLiteDatabase = sachSqlite.getWritableDatabase();

        sqLiteDatabase.delete(USER_TABLE, MAHOADONBAN + "=?", new String[]{id});

    }
}
