package com.example.samee.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class driverreg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverreg);

       //final Dbdriver db=new Dbdriver(this);
        final chh db=new chh(this);
        final TextView driverreg=(TextView)findViewById(R.id.driverreg);
        final TextView license =(TextView)findViewById(R.id.license3);
        final EditText licensetext=(EditText)findViewById(R.id.licensetext3);
        final TextView carmodel=(TextView)findViewById(R.id.model3);
        final EditText carmodeltext=(EditText) findViewById(R.id.modeltext3);
        final TextView carno=(TextView)findViewById(R.id.carno3);
        final EditText carnotext=(EditText)findViewById(R.id.carnotext3);
        final Button submit=(Button)findViewById(R.id.submit3);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=licensetext.getText().toString();
                String s2=carmodeltext.getText().toString();
                String s3=carnotext.getText().toString();
                String s4;
                if((s1.equals(""))||(s2.equals(""))||(s3.equals("")))
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();

                else {
                    //Boolean insert=db.insert(s1,s2,s3);
                    //if(insert==true) {
                       // Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();
                    Bundle bundle=getIntent().getExtras();
                        //Intent intent=getIntent();
                        String text=bundle.getString("email");
                        s4=text;

                        Boolean insert=db.insert(s4,s1,s2,s3);


                if(insert==true) {
                Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(driverreg.this,traveldet.class);
                intent.putExtra("email",s4);
                startActivity(intent);}


                    //}
                        else{
                            Toast.makeText(getApplicationContext(),"not inserted",Toast.LENGTH_SHORT).show();}}


            }
        });


    }
}

