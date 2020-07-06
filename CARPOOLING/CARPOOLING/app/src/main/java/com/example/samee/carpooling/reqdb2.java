package com.example.samee.carpooling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.concurrent.atomic.AtomicBoolean;

public class reqdb2 extends SQLiteOpenHelper {
    public reqdb2(Context context) {
        super(context, "reqdb2.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table require(email text,music text,tv text,pet text,silent_partner text,ac text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists require");
    }


    public boolean insert(String email, String music, String tv, String pet, String silent_partner, String ac) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("music", music);
        contentValues.put("tv", tv);
        contentValues.put("pet", pet);
        contentValues.put("silent_partner", silent_partner);
        contentValues.put("ac", ac);

        long ins = db.insert("require", null, contentValues);
        if (ins == -1)
            return false;
        else
            return true;
    }

    public Cursor getListContents1(){
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor data1=db.rawQuery("select * from "+"require",null);

        return data1;
    }
}




