package com.example.lifecycleawarecomponents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myHolder> {

    private Context context;
    private List<String> list;
    private List<String> arraylist;

    public MyAdapter(List<String> name, Context context) {
        this.list = name;
        this.context = context;
        arraylist=new ArrayList<>();
        arraylist.addAll(list);
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        holder.name.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


        public void myfilter(String charText)
        {
            charText = charText.toLowerCase(Locale.getDefault());
            list.clear();
            if (charText.length() == 0) {
                list.addAll(arraylist);
            } else {
                for (String wp : arraylist) {
                    if (wp.toLowerCase(Locale.getDefault()).contains(charText)) {
                        list.add(wp);
                    }
                }
            }
            notifyDataSetChanged();
        }




    public class myHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
         myHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.itemTV);
            name.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),list.get(getAdapterPosition()),Toast.LENGTH_SHORT).show();
        }
    }
}
