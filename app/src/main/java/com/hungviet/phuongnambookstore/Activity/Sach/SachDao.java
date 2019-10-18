package com.hungviet.phuongnambookstore.Activity.Sach;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hungviet.phuongnambookstore.model.Sach.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachDao {
    private SachSqlite nguoidungSqlite;

    public SachDao(Context context) {
        this.nguoidungSqlite = new SachSqlite(context);
    }

    private String USER_TABLE = "Sach";

    public String TENSACH = "tensach";
    public String TACGIASACH = "tacgiasach";
    public String GIA = "gia";
    public String LUOTXEM = "luotxem";
    public String MASACH = "masach";



    public List<Sach> getAll() {
        List<Sach> sachList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = nguoidungSqlite.getReadableDatabase();

        String SQL = "SELECT * FROM " + USER_TABLE ;

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Sach sach = new Sach();

                    sach.setTen(cursor.getString(cursor.getColumnIndex(TENSACH)));
                    sach.setTacgia(cursor.getString(cursor.getColumnIndex(TACGIASACH)));
                    sach.setGia(cursor.getString(cursor.getColumnIndex(GIA)));
                    sach.setLuotxem(cursor.getString(cursor.getColumnIndex(LUOTXEM)));
                    sach.setMasach(cursor.getString(cursor.getColumnIndex(MASACH)));


                    sachList.add(sach);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return sachList;
    }

    public long insertUser(Sach sach) {
        SQLiteDatabase sqLiteDatabase = nguoidungSqlite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TENSACH, sach.getTen());
        contentValues.put(TACGIASACH, sach.getTacgia());
        contentValues.put(GIA, sach.getGia());
        contentValues.put(LUOTXEM,sach.getLuotxem());
        contentValues.put(MASACH,sach.getMasach());


        long result = sqLiteDatabase.insert(USER_TABLE, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public long updateUser(Sach sach) {
        SQLiteDatabase sqLiteDatabase = nguoidungSqlite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TENSACH, sach.getTen());
        contentValues.put(TACGIASACH, sach.getTacgia());
        contentValues.put(GIA, sach.getGia());
        contentValues.put(LUOTXEM,sach.getLuotxem());
        contentValues.put(MASACH,sach.getMasach());
        long result = sqLiteDatabase.update(USER_TABLE,contentValues, MASACH + "=?", new String[]{sach.getMasach()});
        sqLiteDatabase.close();
        return result;
    }
    public void deleteUser(String id) {
        SQLiteDatabase sqLiteDatabase = nguoidungSqlite.getWritableDatabase();

        sqLiteDatabase.delete(USER_TABLE, MASACH + "=?", new String[]{id});

    }
}
