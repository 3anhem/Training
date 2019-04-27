package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Telephony;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper{
    private static String DB_NAME = "db.SINHVIEN";
    private static int DB_VERSION = 1;
    private static String DB_TABLE = "SINHVIEN";
    private static String ID_SV = "ID_SV";
    private static String NAME_SV = "NAME_SV";
    private static String ADDRESS_SV = "ADDRESS_SV";
    private static String SEX_SV = "SEX_SV";
    private static String IMG_SV = "IMG_SV";
    public MyDatabase(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createDB = "CREATE TABLE "+DB_TABLE+"("
                +ID_SV + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                +NAME_SV + " TEXT,"
                +ADDRESS_SV + " TEXT,"
                +IMG_SV + " TEXT,"
                +SEX_SV + " TEXT)";
        db.execSQL(createDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE);
        onCreate(db);
    }
    public ArrayList<SinhVien> getSinhVienS(){
        ArrayList<SinhVien> arr = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(DB_TABLE,
                new String[]{ID_SV, NAME_SV, ADDRESS_SV, SEX_SV},
                null, null, null, null,null);
        if (cursor.moveToFirst()){
            do{
                SinhVien sv = new SinhVien();
                sv.ID = cursor.getInt(cursor.getColumnIndex(ID_SV));
                sv.Name = cursor.getString(cursor.getColumnIndex(NAME_SV));
                sv.Address = cursor.getString(cursor.getColumnIndex(ADDRESS_SV));
                sv.Sex = cursor.getString(cursor.getColumnIndex(SEX_SV));
                arr.add(sv);
            }while(cursor.moveToNext());
        }
        return arr;
    }
    public Boolean insertSinhVien(SinhVien sv){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(NAME_SV, sv.Name);
        content.put(ADDRESS_SV, sv.Address);
        content.put(SEX_SV, sv.Sex);
        content.put(IMG_SV, sv.Img);
        long result = db.insert(DB_TABLE, null, content);
        sv.ID = (int)result;
        return result > 0;
    }
    public Boolean updateSinhVien(SinhVien sv){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(ID_SV, sv.ID);
        content.put(NAME_SV, sv.Name);
        content.put(ADDRESS_SV, sv.Address);
        content.put(SEX_SV, sv.Sex);
        content.put(IMG_SV, sv.Img);
        long result = db.update(DB_TABLE, content, ID_SV+"="+sv.ID, null);
        return result > 0;
    }
    public Boolean deleteSinhVien(int id){
        SQLiteDatabase db = getWritableDatabase();
        long result = db.delete(DB_TABLE, ID_SV+"="+id, null);
        return result > 0;
    }

}
