package com.example.admin.emergency_tel.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "phone.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "phone";
    private static final String COL_ID = "_id";
    private static final String COL_TITLE = "title";
    private static final String COL_NUMBER = "number";
    private static final String COL_IMAGE = "image";

    private static final String SQL_CREATE_TABLE_PHONE
            = "CREATE TABLE "+TABLE_NAME+ "(" +
            COL_ID +"INTEGER PRIMARY AUTOINCREMENT,"+
            COL_TITLE + " TEXT,"
            + COL_NUMBER + " TEXT,"
            + COL_IMAGE + " TEXT"
            + ")";



    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION); //สร้างฐานข้อมูลว่างๆแล้วส่งไปที่ oncreate

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE_PHONE);

        ContentValues cv= new ContentValues();
        cv.put(COL_TITLE,"สถาบันการแพทย์ฉุกเฉินแห่งชาติ");
        cv.put(COL_NUMBER,"1669");

        db.insert(TABLE_NAME,null,cv);

         cv= new ContentValues();
        cv.put(COL_TITLE,"ศูนย์เอราวัณ สำนักงานแพทย์ กทม.");
        cv.put(COL_NUMBER,"1646");

        db.insert(TABLE_NAME,null,cv);

        cv= new ContentValues();
        cv.put(COL_TITLE,"หน่วยกู้ชีพ วชิรพยาบาล");
        cv.put(COL_NUMBER,"1554");

        db.insert(TABLE_NAME,null,cv);

        cv= new ContentValues();
        cv.put(COL_TITLE,"ศูนย์เอราวัณ สำนักงานแพทย์ กทม.");
        cv.put(COL_NUMBER,"1646");

        db.insert(TABLE_NAME,null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
