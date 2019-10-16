package com.hungviet.phuongnambookstore.model.Sach;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SachRender extends SQLiteOpenHelper {
    public static final String TABLE_ANH="sach";
    public static final String COL_ID="id";
    public static final String COL_ANH="anh";
    public static final String COL_VIEW="view";
    public static final String COL_LUACHON="luachon";
    public static final String COL_TEN="year";
    public static final String COL_TACGIA="tacgia";
    public static final String COL_GIA="gia";
    public static final String COL_LUOTXEM="luotxem";

    public SachRender (Context context){
        super(context,"sach.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_ANH + " ("+COL_ID+" INT PRIMARY KEY ,"+COL_ANH+" INT,"+COL_VIEW+"INT,"+COL_LUACHON+"INT,"+COL_TEN+"TEXT," +
                "" +
                ""+COL_TACGIA+"TEXT,"+COL_GIA+"TEXT,"+COL_LUOTXEM+"TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
