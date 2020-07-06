package com.example.samee.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

public class dridet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dridet);

                final drivregdatabase db=new drivregdatabase(this);
                // final TextView driverreg=(TextView)findViewById(R.id.driverreg);
                final TextView license =(TextView)findViewById(R.id.license3);
                final EditText licensetext=(EditText)findViewById(R.id.licensetext3);
                final TextView carmodel=(TextView)findViewById(R.id.model3);
                final EditText carmodeltext=(EditText) findViewById(R.id.modeltext3);
                final TextView carno=(TextView)findViewById(R.id.carno3);
                final EditText carnotext=(EditText)findViewById(R.id.carnotext3);
                Button sub=(Button)findViewById(R.id.submit3);
                //Button view=(Button)findViewById(R.id.view3);
                final TextView src=(TextView)findViewById(R.id.src3);
                final EditText srctext=(EditText)findViewById(R.id.stext3);
                final TextView dest;
                dest = (TextView)findViewById(R.id.dest3);
                final EditText destext=(EditText) findViewById(R.id.dtext3);
                final TextView stime=(TextView)findViewById(R.id.stime3);
                final EditText stimetxt=(EditText)findViewById(R.id.stimetxt3);

                sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s1 = licensetext.getText().toString();
                        String s2 = carmodeltext.getText().toString();
                        String s3 = carnotext.getText().toString();
                        String s4 = srctext.getText().toString();
                        String s5 = destext.getText().toString();
                        String s6 = stimetxt.getText().toString();
                        String s7;
                        if ((s1.equals("")) || (s2.equals("")) || (s3.equals("")) || (s4.equals("")) || (s5.equals("")) || (s6.equals(""))) {
                            Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                        } else {
                            // String licensepattern="^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$";
                            //if(licensetext.getText().toString().matches(licensepattern)){
                            Bundle bundle=getIntent().getExtras();
                            //Intent intent=getIntent();
                            String text=bundle.getString("email");
                            s7=text;

                            Boolean i = db.insert(s7,s1, s3, s2, s4, s5, s6);
                            if (i == true) {
                                Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(dridet.this, MapsActivity.class);
                                intent.putExtra("email",s7);
                                intent.putExtra("sp",s4);
                                intent.putExtra("dp",s5);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Not inserted", Toast.LENGTH_SHORT).show();
                            }
                        }


                    }

                });

       /* view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dridet.this,listview.class);
                startActivity(intent);
            }
        });*/
            }
        }


