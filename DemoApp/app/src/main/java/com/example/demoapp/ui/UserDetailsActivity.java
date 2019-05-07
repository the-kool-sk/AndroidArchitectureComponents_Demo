package com.example.demoapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.demoapp.R;
import com.example.demoapp.databinding.ActivityUserDetailsBinding;

public class UserDetailsActivity extends AppCompatActivity {

    ActivityUserDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_user_details);


    }
}
