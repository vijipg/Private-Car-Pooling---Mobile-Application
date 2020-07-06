package com.example.samee.carpooling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class try1 extends SQLiteOpenHelper {



        public try1(Context context) {
            super(context, "login1.db",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create table user1(email text primary key,password text,FirstName text,LastName text,PhoneNo text,Aadharno text,Gender text,address text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists user1");
        }
        //insert
        public boolean insert(String email,String password,String FirstName,String LastName,String PhoneNo,String Aadharno,String gender,String address){
            SQLiteDatabase db= this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put("FirstName",FirstName);
            contentValues.put("LastName",LastName);
            contentValues.put("address",address);
            contentValues.put("Password",password);
            contentValues.put("email",email);
            contentValues.put("PhoneNo",PhoneNo);
            contentValues.put("Aadharno",Aadharno);
             contentValues.put("Gender",gender);
            long ins=db.insert("user1",null,contentValues);
            if (ins==-1) {
                return false;
            } else {
                return true;
            }
        }
        //checking if mail exists
        public Boolean chkemail(String email){
            SQLiteDatabase db=this.getReadableDatabase();
            Cursor cursor = db.rawQuery("Select * from user where email=?",new String[]{email});
            if (cursor.getCount()>0)
            {
                return false;
            }
            else {
                return true;
            }
        }
        //checking email and password
        public Boolean emailpassword(String email,String password){
            SQLiteDatabase db=this.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
            if(cursor.getCount()>0)
                return true;
            else
                return false;
        }

    }


