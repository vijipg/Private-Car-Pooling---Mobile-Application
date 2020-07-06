package com.example.samee.carpooling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Dbdriver extends SQLiteOpenHelper {


        public Dbdriver(Context context) {
            super(context,"driver.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create table driver(license text,carmodel text,carno text)");



        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists driver");

        }

        public boolean insert(String license,String carmodel,String carno){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put("license",license);
            contentValues.put("carmodel",carmodel);
            contentValues.put("carno",carno);
            long ins=db.insert("driver",null,contentValues);
            if(ins==-1)

                return false;
            else
                return true;

        }
    public Cursor getListContents(){
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor data=db.rawQuery("select * from "+"driver",null);

        return data;
    }

       /* public String retrieve(){
            SQLiteDatabase db=this.getReadableDatabase();
            String query="Select ";

            return query;
        }*/

    }

