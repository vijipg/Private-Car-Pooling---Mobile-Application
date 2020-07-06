package com.example.samee.carpooling;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class chh extends SQLiteOpenHelper {
    public chh(Context context) {

        super(context,"dchh.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table chha(email text,license text,carmodel text,carno text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                      db.execSQL("drop table if exists chha");
    }
    public boolean insert(String email,String license,String carmodel,String carno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("license", license);
        contentValues.put("carmodel", carmodel);
        contentValues.put("carno", carno);

        long ins = db.insert("chha", null, contentValues);
        if (ins == -1)

            return false;
        else
            return true;

    }}
