package com.example.lackofvision;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CurrentStatusUserAdapter extends RecyclerView.Adapter<CurrentStatusUserAdapter.CurrentStatusUserViewHolder>
{
    String data[];

    public CurrentStatusUserAdapter(String[] data)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public CurrentStatusUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_user_current_status_data_design, parent , false);
        return new CurrentStatusUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentStatusUserViewHolder holder, int position)
    {
        holder.t1.setText(data[position]);
        holder.t2.setText(data[position]);
        holder.t3.setText(data[position]);
    }

    @Override
    public int getItemCount()
    {
        return data.length;
    }

    class CurrentStatusUserViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img1;
        TextView t1, t2, t3;
        EditText et1;

        public CurrentStatusUserViewHolder(@NonNull View itemView)
        {
            super(itemView);
            img1 = (ImageView) itemView.findViewById(R.id.company_logo_current_status);
            t1 = (TextView) itemView.findViewById(R.id.company_name_current_status);
            t2 = (TextView) itemView.findViewById(R.id.company_subject_current_status_txt);
            t3 = (TextView) itemView.findViewById(R.id.company_solution_current_status_txt);
            //et1 = (EditText) itemView.findViewById(R.id.solution_current_status_textbox);
        }
    }
}
