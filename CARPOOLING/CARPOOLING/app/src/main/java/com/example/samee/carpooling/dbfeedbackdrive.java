package com.example.samee.carpooling;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbfeedbackdrive extends SQLiteOpenHelper {

    public dbfeedbackdrive( Context context) {
        super(context,"driver_feedback.db", null, 1);}




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table dfeedback( email_id text,Suggestions text,Comments text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists dfeedback");
    }

    public boolean insert(String email,String suggestions, String comments) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email_id",email) ;
        contentValues.put("Suggestions", suggestions);
        contentValues.put("Comments", comments);
        long ins = db.insert("dfeedback", null, contentValues);
        if (ins == -1)

            return false;
        else
            return true;

    }
}





