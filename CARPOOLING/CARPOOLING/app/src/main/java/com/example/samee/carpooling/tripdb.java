package com.example.samee.carpooling;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class
tripdb extends SQLiteOpenHelper {
    public tripdb(Context context) {
        super(context, "trip.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tripdetails(email_id text,src text,dest text,stime text )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tripdetails");
    }
    //insert
    public  boolean insert(String email_id,String src,String dest,String stime){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email_id",email_id);
        contentValues.put("src",src);
        contentValues.put("dest",dest);
        contentValues.put("stime",stime);
        long ins=db.insert("tripdetails",null,contentValues);
        if(ins==-1)
            return false;
        else
            return true;
    }


}

