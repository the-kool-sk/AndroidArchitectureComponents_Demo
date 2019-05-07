package com.example.demoapp.viewmodel;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.demoapp.DataRepository;
import com.example.demoapp.model.User;
import com.example.demoapp.room.AppDatabase;
import com.example.demoapp.room.userEntity;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    LiveData<? extends User> mobservabledata;
    private final DataRepository mRepository;

    public UserViewModel(@NonNull Application application, int productID) {
        super(application);
        mRepository = DataRepository.getInstance(AppDatabase.getInstance(application.getApplicationContext()));
        mobservabledata=mRepository.getuser(productID);
    }

    public LiveData<? extends User> getObserveableuser()
    {
        return mobservabledata;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;

        private final int muserID;

        public Factory(@NonNull Application application, int userId) {
            mApplication = application;
            muserID = userId;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new UserViewModel(mApplication, muserID);
        }
    }
}
