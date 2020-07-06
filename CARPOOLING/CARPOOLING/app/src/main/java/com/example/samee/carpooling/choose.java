package com.example.samee.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class choose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        final selectdb db=new selectdb(this);

        final RadioButton rb1=(RadioButton)findViewById(R.id.driver);
        final RadioButton rb2=(RadioButton)findViewById(R.id.passenger);
        final Button button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1="no",s2="no",s3;
                Bundle bundle=getIntent().getExtras();

                String text=bundle.getString("email");
                s3=text;
                if(rb1.isChecked()) {
                    s1 = "yes";
                    Boolean insert = db.insert(s3, s1, s2);


                    if (insert == true) {
                        Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(choose.this, req.class);
                        intent.putExtra("email", s3);
                        startActivity(intent);
                    }
                }


                else if(rb2.isChecked())
                {


                    s2="yes";
                    Boolean insert=db.insert(s3,s1,s2);


                    if(insert==true) {
                        Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(choose.this,passdet.class);
                        intent.putExtra("email",s3);

                        startActivity(intent);}

                }



            }
        });
    }
}



