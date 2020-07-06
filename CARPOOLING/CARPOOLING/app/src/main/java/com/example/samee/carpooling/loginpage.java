package com.example.samee.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
       final DatabaseHelper db=new DatabaseHelper(this);
        final TextView welcome=(TextView)findViewById(R.id.welcome);
        final TextView mail=(TextView)findViewById(R.id.textView3_22);
        final EditText editText=(EditText)findViewById(R.id.editText_22);
        final TextView password=(TextView)findViewById(R.id.textView4_1);
        final EditText editText1=(EditText)findViewById(R.id.editText3);
        final Button login=(Button)findViewById(R.id.button);
        final TextView reg=(TextView)findViewById(R.id.reg);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String email=editText.getText().toString();
               // String password=editText1.getText().toString();
                /*Boolean chkemailpass = db.emailpassword(email,password);
                if(chkemailpass==true){*/
                    Intent intent=new Intent(loginpage.this,choose.class);
                    intent.putExtra("email",email);
                    loginpage.this.startActivity(intent);
               /* }
                else
                    Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT).show();*/
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginpage.this,reg.class);
                startActivity(intent);
            }
        });

    }}




