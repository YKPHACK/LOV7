package com.example.lackofvision;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CompaniesUserActivity extends AppCompatActivity
{
    RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_companies);

        rcv = (RecyclerView) findViewById(R.id.nav_recview_user_companies);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        String arr[] = {"c","c++","java","PHP","c","c++","java","PHP","c","c++","java","PHP","c","c++","java","PHP",};
        rcv.setAdapter(new com.example.lackofvision.CompaniesUserAdapter(arr));
    }
}