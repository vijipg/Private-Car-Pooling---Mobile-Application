package com.example.samee.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class feedbackdrive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackdrive);

        final dbfeedbackdrive db=new dbfeedbackdrive(this);

        final TextView suggestion=(TextView)findViewById(R.id.suggestion2);
        final EditText sugtxt=(EditText) findViewById(R.id.sugtxt2);
        final TextView comments=(TextView) findViewById(R.id.comments2);
        final EditText commenttxt=(EditText) findViewById(R.id.commenttxt2);
        final Button submit=(Button)findViewById(R.id.submit2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = sugtxt.getText().toString();
                String s2 = commenttxt.getText().toString();
                String s3;
                if ((s1.equals("")) || (s2.equals("")))
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                else {
                    Bundle bundle = getIntent().getExtras();
                    String text = bundle.getString("email");
                    s3 = text;
                    Boolean insert = db.insert(s3,s1,s2);
                    if (insert == true) {
                        Toast.makeText(getApplicationContext(), "inserted Successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(feedbackdrive.this, thank1.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "not inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}





