package com.example.samee.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class traveldet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traveldet);
        final tripdb db=new tripdb(this);
        TextView details=(TextView)findViewById(R.id.details);
        final TextView src=(TextView)findViewById(R.id.src);
        final EditText srctext=(EditText)findViewById(R.id.srctext);
        final TextView dest=(TextView)findViewById(R.id.dest);
        final EditText destext=(EditText) findViewById(R.id.destext);
        final TextView stime=(TextView)findViewById(R.id.stime3);
        final EditText stimetxt=(EditText)findViewById(R.id.stimetxt);
        final Button start=(Button)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = srctext.getText().toString();
                String s2 = destext.getText().toString();
                String s3 = stimetxt.getText().toString();
                String s4;
                if ((s1.equals("")) || (s2.equals("")) || (s3.equals("")))
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                else {
                    Bundle bundle = getIntent().getExtras();
                    String text = bundle.getString("email");
                    s4 = text;
                    Toast.makeText(getApplicationContext(), s4, Toast.LENGTH_SHORT).show();
                    Boolean insert = db.insert(s4, s1, s2, s3);
                    if (insert == true) {
                        Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(traveldet.this, req.class);
                        intent.putExtra("email",s4);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "not inserted", Toast.LENGTH_SHORT).show();


                    }
                }
            }
        });
    }
}

