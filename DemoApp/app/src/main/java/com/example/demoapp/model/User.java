package com.example.demoapp.model;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public interface User {

    String getUser_display_name();
    String getUser_email();
    String getUser_photo();
    String getUser_mob_num();
    int getID();
    }
