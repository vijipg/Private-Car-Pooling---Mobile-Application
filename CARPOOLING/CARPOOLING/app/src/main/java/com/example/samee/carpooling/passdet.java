package com.example.samee.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class passdet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passdet);

        final dbtrippass db=new dbtrippass(this);
        TextView details = (TextView) findViewById(R.id.details1);
        final TextView src = (TextView) findViewById(R.id.src1);
        final EditText srctext = (EditText) findViewById(R.id.srctext1);
        final TextView dest = (TextView) findViewById(R.id.dest1);
        final EditText destext = (EditText) findViewById(R.id.destext1);
        final TextView stime = (TextView) findViewById(R.id.stime1);
        final EditText stimetxt = (EditText) findViewById(R.id.stimetxt1);
        final Button start = (Button) findViewById(R.id.okk);
        final Button view=(Button)findViewById(R.id.view);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = srctext.getText().toString();
                String s2 = destext.getText().toString();
                String s3 = stimetxt.getText().toString();
                String s4;
                if ((s1.equals("")) || (s2.equals("")) || (s3.equals("")))
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
               else{
                   Bundle bundle = getIntent().getExtras();
                String text = bundle.getString("email");
                s4 = text;

                Boolean insert = db.insert(s4, s1, s2, s3);
                if (insert == true) {
                    Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(passdet.this, MapsActivity.class);
                    intent.putExtra("email",s4);
                    intent.putExtra("sp",s1);
                    intent.putExtra("dp",s2);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "not inserted", Toast.LENGTH_SHORT).show();


                }}

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(passdet.this,listview.class);
                startActivity(intent);
            }
        });

    }
}
