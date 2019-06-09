package com.example.demoapp.ui;

import android.annotation.TargetApi;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.demoapp.R;

public class BindingAdapters {

    @BindingAdapter({"user_photo"})

    public static void loadimage(ImageView imageView, String url)
    {
        Glide.with(imageView.getContext())
                .load(url)
                .centerInside()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }

    /*@BindingAdapter({"android:src"})
    public static void loadimage(ImageView imageView, String url)
    {
        Glide.with(imageView.getContext())
                .load(url)
                .centerInside()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }*/
}
