package com.example.lackofvision;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class userlogin extends AppCompatActivity {

    private EditText US;
    private EditText pass;
    private Button login;
    public Button sup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        US=(EditText)findViewById(R.id.edus);
        pass=(EditText)findViewById(R.id.editTextTextPassword2);
        login=(Button)findViewById(R.id.button5);
        sup=(Button)findViewById(R.id.button4);

        login.setOnClickListener(view -> validate(US.getText().toString(),pass.getText().toString()));
    }

    private void validate(String username,String userpass)
    {
        if ((username.equals("user")) && (userpass.equals("12345")))
        {
            Intent intent = new Intent(this,userhome.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"You have entered wrong password",Toast.LENGTH_LONG).show();

        }
    }

    public void sup(View view) {
        Intent intent = new Intent(this,userhome.class);
        startActivity(intent);
    }

}