package com.example.lackofvision;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CurrentStatusUserActivity extends AppCompatActivity
{
    RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_current_status);

        rcv = (RecyclerView) findViewById(R.id.nav_recview_user_current_status);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        String arr[] = {"c","c++","java","PHP","c","c++","java","PHP","c","c++","java","PHP","c","c++","java","PHP",};
        rcv.setAdapter(new com.example.lackofvision.CurrentStatusUserAdapter(arr));
    }
}
