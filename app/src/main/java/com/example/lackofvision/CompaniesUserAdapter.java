package com.example.lackofvision;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CompaniesUserAdapter extends RecyclerView.Adapter<CompaniesUserAdapter.CompanyUserViewHolder>
{
    String data[];

    public CompaniesUserAdapter(String[] data)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public CompanyUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_user_companies_data_design, parent , false);
        return new CompanyUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyUserViewHolder holder, int position)
    {
        holder.t1.setText(data[position]);
        holder.t2.setText(data[position]);
    }

    @Override
    public int getItemCount()
    {
        return data.length;
    }

    class CompanyUserViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img1;
        TextView t1, t2;

        public CompanyUserViewHolder(@NonNull View itemView)
        {
            super(itemView);
            img1 = (ImageView) itemView.findViewById(R.id.company_logo);
            t1 = (TextView) itemView.findViewById(R.id.company_name);
            t2 = (TextView) itemView.findViewById(R.id.company_description);
        }
    }
}
