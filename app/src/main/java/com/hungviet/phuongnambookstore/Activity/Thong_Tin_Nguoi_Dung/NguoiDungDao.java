package com.hungviet.phuongnambookstore.Activity.Thong_Tin_Nguoi_Dung;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hungviet.phuongnambookstore.Activity.Sach.SachSqlite;
import com.hungviet.phuongnambookstore.model.Person;
import com.hungviet.phuongnambookstore.model.Sach.Sach;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDao {
    private SachSqlite nguoidungSqlite;

    public NguoiDungDao(Context context) {
        this.nguoidungSqlite = new SachSqlite(context);
    }

    private String USER_TABLE = "Nguoidung";

    public String SDT = "sdt";
    public String EMAIL = "email";
    public String HOTEN = "hoten";
    public String MATKHAU = "matkhau";
    public String MANGUOIDUNG = "manguoidung";



    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = nguoidungSqlite.getReadableDatabase();

        String SQL = "SELECT * FROM " + USER_TABLE ;

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Person person = new Person();

                    person.setSdt(cursor.getString(cursor.getColumnIndex(SDT)));
                    person.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
                    person.setHoten(cursor.getString(cursor.getColumnIndex(HOTEN)));
                    person.setMatkhau(cursor.getString(cursor.getColumnIndex(MATKHAU)));
                    person.setManguoidung(cursor.getString(cursor.getColumnIndex(MANGUOIDUNG)));


                    personList.add(person);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return personList;
    }

    public long insertUser(Person person) {
        SQLiteDatabase sqLiteDatabase = nguoidungSqlite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SDT, person.getSdt());
        contentValues.put(EMAIL, person.getEmail());
        contentValues.put(HOTEN, person.getHoten());
        contentValues.put(MATKHAU,person.getMatkhau());
        contentValues.put(MANGUOIDUNG,person.getManguoidung());


        long result = sqLiteDatabase.insert(USER_TABLE, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public long updateUser(Person person) {
        SQLiteDatabase sqLiteDatabase = nguoidungSqlite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SDT, person.getSdt());
        contentValues.put(EMAIL, person.getEmail());
        contentValues.put(HOTEN, person.getHoten());
        contentValues.put(MATKHAU,person.getMatkhau());
        contentValues.put(MANGUOIDUNG,person.getManguoidung());

        long result = sqLiteDatabase.update(USER_TABLE,contentValues, MANGUOIDUNG + "=?", new String[]{person.getManguoidung()});
        sqLiteDatabase.close();
        return result;
    }
    public void deleteUser(String id) {
        SQLiteDatabase sqLiteDatabase = nguoidungSqlite.getWritableDatabase();

        sqLiteDatabase.delete(USER_TABLE, MANGUOIDUNG + "=?", new String[]{id});

    }
}
