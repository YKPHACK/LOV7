package com.example.lackofvision;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Companylogin extends AppCompatActivity {

    private EditText cn;
    private EditText pass;
    private Button cnlog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companylogin);

        cn=(EditText)findViewById(R.id.edcn);
        pass=(EditText)findViewById(R.id.edps);
        cnlog=(Button)findViewById(R.id.button8);

        cnlog.setOnClickListener(view -> validate(cn.getText().toString(),pass.getText().toString()));
    }

    private void validate(String companyname,String companypass)
    {
        if ((companyname.equals("facebook")) && (companypass.equals("12345")))
        {
            Intent intent = new Intent(this,companyhome.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"You have entered wrong password",Toast.LENGTH_LONG).show();

        }
    }


}