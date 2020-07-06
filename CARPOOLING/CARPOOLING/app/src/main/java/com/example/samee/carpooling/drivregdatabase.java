package com.example.samee.carpooling;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class drivregdatabase extends SQLiteOpenHelper {
    public drivregdatabase(Context context) {
        super(context,"driver3.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table drivermod(email text,license text,carno text,carmodel text,sourcepoint text,destinationpoint text,startingtime text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists drivermod");
    }
    public boolean insert(String email,String license, String carno, String carmodel,String sourcepoint,String destinationpoint,String startingtime) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("license",license);
        contentValues.put("carno",carno);
        contentValues.put("carmodel",carmodel);
        contentValues.put("sourcepoint",sourcepoint);
        contentValues.put("destinationpoint",destinationpoint);
        contentValues.put("startingtime",startingtime);
        long ins=db.insert("drivermod",null,contentValues);
        if(ins==-1)
            return false;
        else
            return true;
    }
    public Cursor getListContents(){
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor data=db.rawQuery("select * from "+"drivermod",null);

        return data;
    }
    /*public String retrieve(){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="Select ";
        return query;
    }*/
}
