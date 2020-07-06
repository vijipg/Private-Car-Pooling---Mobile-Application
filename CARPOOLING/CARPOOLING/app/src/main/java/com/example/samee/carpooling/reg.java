package com.example.samee.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class reg extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_reg);

            final DatabaseHelper db = new DatabaseHelper(this);
            final TextView Registration = (TextView) findViewById(R.id.textView6);
            final TextView fn = (TextView) findViewById(R.id.textView7);
            final EditText etf = (EditText) findViewById(R.id.editText2);
            final TextView ln = (TextView) findViewById(R.id.textView8);
            final EditText etl = (EditText) findViewById(R.id.editText4);
            final TextView address = (TextView) findViewById(R.id.textView9);
            final EditText eta = (EditText) findViewById(R.id.editText6);
            final TextView password = (TextView) findViewById(R.id.textView10);
            final EditText etp = (EditText) findViewById(R.id.editText7);
            final TextView confirm = (TextView) findViewById(R.id.textView11);
            final EditText etc = (EditText) findViewById(R.id.editText8);
            final TextView mail = (TextView) findViewById(R.id.textView12);
            final EditText etm = (EditText) findViewById(R.id.editText9);
            final TextView phone = (TextView) findViewById(R.id.textView13);
            final EditText editText = (EditText) findViewById(R.id.editText10);
            final TextView gender = (TextView) findViewById(R.id.textView14);
            final RadioButton male = (RadioButton) findViewById(R.id.radioButton);
            final RadioButton female = (RadioButton) findViewById(R.id.radioButton2);
           // final RadioGroup rg=(RadioGroup)findViewById(R.id.rg);
            final TextView ano = (TextView) findViewById(R.id.textView15);
            final EditText etaadhar = (EditText) findViewById(R.id.editText12);
            final Button register = (Button) findViewById(R.id.button2);
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s1 = etf.getText().toString();
                    String s2 = etl.getText().toString();
                    String s3 = eta.getText().toString();
                    String s4 = etp.getText().toString();
                    String s5 = etc.getText().toString();

                    String s6 = etm.getText().toString();
                    String s7 = editText.getText().toString();
                    String s8 = etaadhar.getText().toString();
                   // String s9;
                    if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals("") || s7.equals("") || s8.equals("")) {
                        Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                    } else {
                        boolean result = Verhoeff.validateVerhoeff(s8);
                        String msg = String.valueOf(result);
                        String email = etm.getText().toString().trim();
                        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                        String MobilePattern = "[0-9]{10}";
                       /* if(male.isChecked())
                            s9="Male";
                        else
                            s9="Female";*/
                        if (msg == "true") {
                            if (s4.equals(s5)) {
                                Boolean chkemail = db.chkemail(s6);
                                if (chkemail == true) {
                                    if (email.matches(emailPattern)) {
                                        if (editText.getText().toString().matches(MobilePattern)) {
                                            Boolean insert = db.insert(s6, s4, s1, s2, s7, s8, s3);
                                            if (insert == true) {
                                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(reg.this, choose.class);
                                                intent.putExtra("email", s6);
                                                startActivity(intent);
                                            }
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Enter a valid phone", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Enter a valid email address", Toast.LENGTH_SHORT).show();
                                    }

                                } else {
                                    Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Enter a valid Aadhar number", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            });
        }}






