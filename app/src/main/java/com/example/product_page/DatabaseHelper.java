package com.example.product_page;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String name = "foodie_zone";

    public DatabaseHelper(Context context) {
        super(context, "foodie_zone", (CursorFactory)null, 1);
    }

    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create table users(UserName TEXT ,Email TEXT primary key,Password TEXT,Gender TEXT,Country TEXT)");
    }

    public void onUpgrade(SQLiteDatabase MyDatabase, int arg1, int arg2) {
        MyDatabase.execSQL("drop table if exists users");
        this.onCreate(MyDatabase);
    }

    public Boolean InsertData(String name, String email, String pass, String country, String gender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("UserName", name);
        values.put("Email", email);
        values.put("Password", pass);
        values.put("Gender", gender);
        values.put("Country", country);
        long result = db.insert("users", (String)null, values);
        db.close();
        return result == -1L ? false : true;
    }

    public Boolean CheckEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?", new String[]{email});
        return cursor.getCount() > 0 ? true : false;
    }

    public Boolean Checkpass(String password, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and password=?", new String[]{email, password});
        return cursor.getCount() > 0 ? true : false;
    }
}

