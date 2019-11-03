//package com.hungviet.phuongnambookstore.Activity.Top_Ban_Chay;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import com.hungviet.phuongnambookstore.Activity.Sach.SachSqlite;
//import com.hungviet.phuongnambookstore.model.Sach.Sach;
//import com.hungviet.phuongnambookstore.model.Top_Ban_Chay;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TopDao {
//    private SachSqlite nguoidungSqlite;
//
//    public TopDao(Context context) {
//        this.nguoidungSqlite = new SachSqlite(context);
//    }
//
//    private String USER_TABLE = "Topbanchay";
//
//    public String NAME = "name";
//    public String THELOAI = "tacgiasach";
//    public String SOLUONG = "gia";
//    public String MASACHBANCHAY = "masachbanchay";
//
//
//
//    public List<Top_Ban_Chay> getAll() {
//        List<Top_Ban_Chay> top_ban_chayList = new ArrayList<>();
//
//        SQLiteDatabase sqLiteDatabase = nguoidungSqlite.getReadableDatabase();
//
//        String SQL = "SELECT * FROM " + USER_TABLE ;
//
//        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
//
//        if (cursor != null) {
//            if (cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//                while (!cursor.isAfterLast()) {
//
//                    Top_Ban_Chay top_ban_chay = new Top_Ban_Chay();
//
//                    top_ban_chay.setName(cursor.getString(cursor.getColumnIndex(NAME)));
//                    top_ban_chay.setTheloai(cursor.getString(cursor.getColumnIndex(THELOAI)));
//                    top_ban_chay.setSoluong(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SOLUONG))));
//                    top_ban_chay.setMasachbanchay(cursor.getString(cursor.getColumnIndex(MASACHBANCHAY)));
//
//                    top_ban_chayList.add(top_ban_chay);
//                    cursor.moveToNext();
//
//                }
//                cursor.close();
//            }
//        }
//
//        return top_ban_chayList;
//    }
//
//    public long insertUser(Top_Ban_Chay top_ban_chay) {
//        SQLiteDatabase sqLiteDatabase = nguoidungSqlite.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(NAME, top_ban_chay.getName());
//        contentValues.put(THELOAI, top_ban_chay.getTheloai());
//        contentValues.put(SOLUONG, top_ban_chay.getSoluong());
//        contentValues.put(MASACHBANCHAY,top_ban_chay.getMasachbanchay());
//
//
//        long result = sqLiteDatabase.insert(USER_TABLE, null, contentValues);
//        sqLiteDatabase.close();
//        return result;
//    }
//
//    public long updateUser(Top_Ban_Chay top_ban_chay) {
//        SQLiteDatabase sqLiteDatabase = nguoidungSqlite.getWritableDatabase();
//
//
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(NAME, top_ban_chay.getName());
//        contentValues.put(THELOAI, top_ban_chay.getTheloai());
//        contentValues.put(SOLUONG, top_ban_chay.getSoluong());
//        contentValues.put(MASACHBANCHAY,top_ban_chay.getMasachbanchay());
//
//        long result = sqLiteDatabase.update(USER_TABLE,contentValues, MASACHBANCHAY + "=?", new String[]{top_ban_chay.getMasachbanchay()});
//        sqLiteDatabase.close();
//        return result;
//    }
//    public void deleteUser(String id) {
//        SQLiteDatabase sqLiteDatabase = nguoidungSqlite.getWritableDatabase();
//
//        sqLiteDatabase.delete(USER_TABLE, MASACHBANCHAY + "=?", new String[]{id});
//
//    }
//    /////////
//}
