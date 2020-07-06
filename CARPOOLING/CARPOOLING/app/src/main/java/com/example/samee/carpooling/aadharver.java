package com.example.samee.carpooling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class aadharver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadharver);

        final TextView welcome=(TextView)findViewById(R.id.welcome);
        final TextView mail=(TextView)findViewById(R.id.textView3_2);
        final EditText editText=(EditText)findViewById(R.id.editText_2);
        final TextView password=(TextView)findViewById(R.id.textView4_2);
        final EditText editText1=(EditText)findViewById(R.id.editText3_2);
        final Button login=(Button)findViewById(R.id.button_2);
       /* login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=editText.getText().toString();
                String password=editText1.getText().toString();

                if(email=="aadhar123@gmail.com" && password=="techkidzzz")
                    Toast.makeText(getApplicationContext(),"Access Granted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
