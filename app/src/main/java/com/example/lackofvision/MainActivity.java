package com.example.lackofvision;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button s1,p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = findViewById(R.id.button);
        p2 = findViewById(R.id.button2);

    }

    public void p2(View view) {
        Intent intent = new Intent(this,userlogin.class);
        startActivity(intent);
    }

    public void s1(View view) {
        Intent intent = new Intent(this,Companylogin.class);
        startActivity(intent);

    }
}