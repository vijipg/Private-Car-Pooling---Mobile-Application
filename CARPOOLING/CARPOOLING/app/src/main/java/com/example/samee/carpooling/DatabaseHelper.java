package com.example.samee.carpooling;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, "login.db",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create table user(email text primary key,password text,FirstName text,LastName text,PhoneNo text,Aadharno text,address text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists user");
        }
        //insert
        public boolean insert(String email,String password,String FirstName,String LastName,String PhoneNo,String Aadharno,String address){
            SQLiteDatabase db= this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put("FirstName",FirstName);
            contentValues.put("LastName",LastName);
            contentValues.put("address",address);
            contentValues.put("Password",password);
            contentValues.put("email",email);
            contentValues.put("PhoneNo",PhoneNo);
            contentValues.put("Aadharno",Aadharno);
           // contentValues.put("Gender",gender);
            long ins=db.insert("user",null,contentValues);
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
    public Cursor getListContents2(){
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor data2=db.rawQuery("select * from "+"user",null);

        return data2;
    }


    }

