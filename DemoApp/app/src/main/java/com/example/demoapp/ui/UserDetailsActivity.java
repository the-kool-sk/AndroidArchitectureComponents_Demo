package com.example.demoapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.demoapp.R;
import com.example.demoapp.databinding.ActivityUserDetailsBinding;
import com.example.demoapp.model.User;
import com.example.demoapp.viewmodel.UserListViewModel;
import com.example.demoapp.viewmodel.UserViewModel;

public class UserDetailsActivity extends AppCompatActivity {

    ActivityUserDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_user_details);
        UserViewModel.Factory factory = new UserViewModel.Factory(getApplication(),
                                        getIntent().getIntExtra("key",0));
        UserViewModel viewModel = ViewModelProviders.of(this,factory).get(UserViewModel.class);
        subscribeToUI(viewModel.getObserveableuser());
    }

    private void subscribeToUI(LiveData<? extends User> userLiveData) {
        userLiveData.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                binding.setProfile(user);
                binding.setUserImage(user.getUser_photo());
            }
        });
    }
}
