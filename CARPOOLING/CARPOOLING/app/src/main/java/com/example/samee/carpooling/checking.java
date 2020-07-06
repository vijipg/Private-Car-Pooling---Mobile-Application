package com.example.samee.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class checking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking);
        final Button b1=(Button)findViewById(R.id.register);
        final Button b2=(Button)findViewById(R.id.aadhar);
        final Button b3=(Button)findViewById(R.id.lic);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(checking.this,loginpage.class);
                startActivity(i);
            }
        });


     b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(checking.this,aadharver.class);
            startActivity(i);
        }
    });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(checking.this,licensever.class);
                startActivity(i);
            }
        });



}
}
