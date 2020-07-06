package com.example.samee.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class req extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_req);
        final reqdb2 db = new reqdb2(this);
       // final DatabaseHelper dbb=new DatabaseHelper(this);
        final CheckBox music = (CheckBox) findViewById(R.id.music);
        final CheckBox tv = (CheckBox) findViewById(R.id.tv);
        final CheckBox pet = (CheckBox) findViewById(R.id.pet);
        final CheckBox sipa = (CheckBox) findViewById(R.id.sipa);
        final CheckBox ac = (CheckBox) findViewById(R.id.ac);

        final Button okay = (Button) findViewById(R.id.okay);

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1, s2, s3, s4, s5,s6;

                if (music.isChecked())
                    s1 = "yes";

                else
                    s1 = "no";
                if (tv.isChecked())
                    s2 = "yes";

                else
                    s2 = "no";
                if (pet.isChecked())
                    s3 = "yes";
                else
                    s3 = "no";
                if (sipa.isChecked())
                    s4 = "yes";

                else
                    s4 = "no";
                if (ac.isChecked())
                    s5 = "yes";

                else
                    s5 = "no";


                Bundle bundle=getIntent().getExtras();

                String text=bundle.getString("email");
                s6=text;

                Boolean insert=db.insert(s6,s1,s2,s3,s4,s5);


                if(insert==true) {
                    Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(req.this,dridet.class);
                    intent.putExtra("email",s6);

                    startActivity(intent);}



                 else {
                    Toast.makeText(getApplicationContext(), "not inserted", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }    }