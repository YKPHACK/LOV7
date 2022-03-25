package com.example.lackofvision;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CompaniesUserViewHolder extends RecyclerView.ViewHolder
{
    ImageView img1;
    TextView t1, t2;

    public CompaniesUserViewHolder(@NonNull View itemView)
    {
        super(itemView);
        img1 = (ImageView) itemView.findViewById(R.id.company_logo);
        t1 = (TextView) itemView.findViewById(R.id.company_name);
        t2 = (TextView) itemView.findViewById(R.id.company_description);
    }
}