package com.example.demoapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.demoapp.R;
import com.example.demoapp.databinding.UserDetailsActivityBinding;
import com.example.demoapp.model.User;
import com.example.demoapp.viewmodel.UserViewModel;

public class UserDetailsActivity extends AppCompatActivity {

    UserDetailsActivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.user_details_activity);
        UserViewModel.Factory factory = new UserViewModel.Factory(getApplication(),
                                        getIntent().getIntExtra("key",0));
        binding.setLifecycleOwner(this);
        UserViewModel viewModel = ViewModelProviders.of(this,factory).get(UserViewModel.class);
        subscribeToUI(viewModel.getObserveableuser());
    }

    private void subscribeToUI(LiveData<? extends User> userLiveData) {
        userLiveData.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                binding.setProfile(user);
            }
        });
    }
}
