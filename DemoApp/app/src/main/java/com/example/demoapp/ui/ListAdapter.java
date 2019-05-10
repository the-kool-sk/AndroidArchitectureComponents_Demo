package com.example.demoapp.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapp.R;
import com.example.demoapp.databinding.ListitemBinding;
import com.example.demoapp.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.userHolder> {

    private List<? extends User> list = new ArrayList<>();
    private ClickCallBack clickcallback;

    public ListAdapter(ClickCallBack clickcallback) {
        this.clickcallback = clickcallback;
    }

    public void setUserList(List<? extends User> userList) {
        list = userList;
        Collections.reverse(list);

        notifyDataSetChanged();
        //notifyItemRangeInserted(0,userList.size());
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListitemBinding listitemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.listitem,
                parent, false);
        listitemBinding.setCallback(clickcallback);
        return new userHolder(listitemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull userHolder holder, int position) {
        holder.binding.setUser(list.get(position));
        holder.binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getID();
    }

    public static class userHolder extends RecyclerView.ViewHolder {

        ListitemBinding binding;

        public userHolder(ListitemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
