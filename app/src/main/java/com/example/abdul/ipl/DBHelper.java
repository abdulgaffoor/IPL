package com.example.abdul.ipl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String TABLE_NAME = "IPL_TABLE";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "RCB";
    public static final String COL_3 = "MI";
    public static final String COL_4 = "KKR";
    public static final String COL_5 = "GL";
    public static final String COL_6 = "SRH";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table "+ TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,RCB INTEGER,MI INTEGER,KKR INTEGER,GL INTEGER,SRH INETEGER)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(int RCBs, int MIs, int KKRs, int GLs, int SRHs) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, RCBs);
        contentValues.put(COL_3, MIs);
        contentValues.put(COL_4, KKRs);
        contentValues.put(COL_5, GLs);
        contentValues.put(COL_6, SRHs);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}