package com.example.samee.carpooling;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listview extends AppCompatActivity{
    drivregdatabase db;
    reqdb2 db1;
    DatabaseHelper db2;
    @Override
            protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_listview);
                ListView listView=(ListView)findViewById(R.id.listview);
                db=new drivregdatabase(this);
                db1=new reqdb2(this);
                db2=new DatabaseHelper(this);
                ArrayList<String> mylist=new ArrayList<>();
                Cursor data= db.getListContents();
                Cursor data1=db1.getListContents1();
                Cursor data2=db2.getListContents2();
                if(data.getCount()==0 ){

                    Toast.makeText(listview.this, "Database is empty", Toast.LENGTH_LONG).show();
                }
                else{
                    while(data.moveToNext() && data1.moveToNext() && data2.moveToNext()) {


                        mylist.add("\t\t");

                        mylist.add(data.getColumnName(1));
                        mylist.add(data.getString(1));
                        mylist.add(data.getColumnName(2));
                        mylist.add(data.getString(2));
                        mylist.add(data.getColumnName(3));
                        mylist.add(data.getString(3));
                        mylist.add(data.getColumnName(4));
                        mylist.add(data.getString(4));
                        mylist.add(data.getColumnName(5));
                        mylist.add(data.getString(5));

                        mylist.add(data1.getColumnName(1));
                        mylist.add(data1.getString(1));
                        mylist.add(data1.getColumnName(2));
                        mylist.add(data1.getString(2));
                        mylist.add(data1.getColumnName(3));
                        mylist.add(data1.getString(3));
                        mylist.add(data1.getColumnName(4));
                        mylist.add(data1.getString(4));
                        mylist.add(data1.getColumnName(5));
                        mylist.add(data1.getString(5));
                        mylist.add(data2.getColumnName(4));
                        mylist.add(data2.getString(4));
                        mylist.add("\n***************************************");

                    }
                }
                ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mylist);
                listView.setAdapter(listAdapter);

                    }


}



