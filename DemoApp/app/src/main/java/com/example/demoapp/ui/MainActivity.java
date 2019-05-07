package com.example.demoapp.ui;


import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.demoapp.R;
import com.example.demoapp.databinding.ActivityMainBinding;
import com.example.demoapp.room.userEntity;
import com.example.demoapp.viewmodel.UserListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        listAdapter= new ListAdapter(mclickcallback);
       // binding.userListRV.setLayoutManager(new LinearLayoutManager(this));
        binding.userListRV.setAdapter(listAdapter);
        new MainActivityLifeCycleObserver(this,this);
        final UserListViewModel userListViewModel = ViewModelProviders.of(this).get(UserListViewModel.class);
        subscribeUI(userListViewModel.getObserveableusers());
    }

    private void subscribeUI(LiveData<List<userEntity>> observeableusers) {
        observeableusers.observe(this, new Observer<List<userEntity>>() {
            @Override
            public void onChanged(List<userEntity> userEntities) {
            if(userEntities!=null)
            {
                listAdapter.setUserList(userEntities);
            }
            binding.executePendingBindings();

            }
        });
    }
    private final ClickCallBack mclickcallback = () ->
            Toast.makeText(getApplicationContext(),"itemclicked",Toast.LENGTH_SHORT).show();

}
