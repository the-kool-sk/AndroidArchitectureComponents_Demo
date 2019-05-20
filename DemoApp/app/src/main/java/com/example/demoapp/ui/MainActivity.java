package com.example.demoapp.ui;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.demoapp.R;
import com.example.demoapp.databinding.ActivityMainBinding;
import com.example.demoapp.generated.callback.OnClickListener;
import com.example.demoapp.model.User;
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
        binding.rvUserList.setAdapter(listAdapter);
        binding.setLifecycleOwner(this);
        new MainActivityLifeCycleObserver(this,this);
        final UserListViewModel userListViewModel = ViewModelProviders.of(this).get(UserListViewModel.class);
        subscribeUI(userListViewModel.getObserveableusers());
        binding.btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userListViewModel.insertUser();
            }
        });
    }

    private void subscribeUI(LiveData<List<userEntity>> observeableusers) {
        observeableusers.observe(this, new Observer<List<userEntity>>() {
            @Override
            public void onChanged(List<userEntity> userEntities) {
                if (userEntities != null) {
                    listAdapter.setUserList(userEntities);
                    Log.i("OnChange", "called");
                }
                binding.executePendingBindings();
            }
        });

/* // With Lambda function
    private void subscribeUI(LiveData<List<userEntity>> observeableusers) {
        observeableusers.observe(this, userEntities -> {
        if(userEntities!=null)
        {
            listAdapter.setUserList(userEntities);
            Log.i("OnChange","called");
        }
        binding.executePendingBindings();

        });
    }*/
    }
    private final ClickCallBack mclickcallback = user -> {
        Intent intent = new Intent(getApplicationContext(),UserDetailsActivity.class);
        intent.putExtra("key",user.getID());
        startActivity(intent);

    };

}
