package com.example.samee.carpooling;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbtrippass extends SQLiteOpenHelper {

    public dbtrippass(Context context) {
        super(context,"passengertravel.db", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tripdetails(email_id text,source_point text,destination_point text,starting_time text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tripdetails");
    }

    public  boolean insert(String email_id,String src,String dest,String stime){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email_id",email_id);
        contentValues.put("source_point",src);
        contentValues.put("destination_point",dest);
        contentValues.put("starting_time",stime);
        long ins=db.insert("tripdetails",null,contentValues);
        if(ins==-1)
            return false;
        else
            return true;
    }


}



