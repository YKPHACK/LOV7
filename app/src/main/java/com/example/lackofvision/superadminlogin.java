package com.example.lackofvision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class superadminlogin extends AppCompatActivity {

    private EditText sp;
    private EditText pass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superadminlogin);

        sp=(EditText)findViewById(R.id.usp);
        pass=(EditText)findViewById(R.id.pass1);
        login=(Button)findViewById(R.id.button3);

        login.setOnClickListener(view -> validate(sp.getText().toString(),pass.getText().toString()));
    }

    private void validate(String username,String userpass)
    {
        if ((username.equals("YKP")) && (userpass.equals("12345")))
        {
           
        }
        else {
            Toast.makeText(this,"You have entered wrong password",Toast.LENGTH_LONG).show();

        }
    }
}