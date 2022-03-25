package com.example.lackofvision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

public class firebase_database_conn extends AppCompatActivity {

    public Button b1;

    public EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_database_conn);

        b1=(Button)findViewById(R.id.button6);
        name=(EditText)findViewById(R.id.name);



    }


    public void data(View view) {

        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference root= db.getReference();

        root.push().setValue(name.getText().toString());
        name.setText("");
        Toast.makeText(getApplicationContext(), "Value is inserted", Toast.LENGTH_LONG).show();
    }
}

