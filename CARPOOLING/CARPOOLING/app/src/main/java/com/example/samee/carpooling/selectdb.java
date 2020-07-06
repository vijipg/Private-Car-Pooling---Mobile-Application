package com.example.samee.carpooling;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class selectdb extends SQLiteOpenHelper {
    public selectdb(Context context){
        super(context,"choice.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table selection(email_id text,Driver text,Passenger text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists seletion");
    }
        public boolean insert(String email,String driver, String passenger) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("email_id", email);
            contentValues.put("Driver", driver);
            contentValues.put("Passenger", passenger);
            long ins = db.insert("selection", null, contentValues);
            if (ins == -1)
                return false;
            else
                return true;
        }
    }



