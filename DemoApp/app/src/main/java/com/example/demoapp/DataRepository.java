package com.example.demoapp;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.room.RawQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;

import com.example.demoapp.model.User;
import com.example.demoapp.model.UserResponceModel;
import com.example.demoapp.retrofit.ApiClient;
import com.example.demoapp.retrofit.EndPoints;
import com.example.demoapp.room.AppDatabase;
import com.example.demoapp.room.userEntity;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    private final AppDatabase mDatabase;
    private static DataRepository sInstance;
    private DataRepository(final AppDatabase database) {
        mDatabase = database;
    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    public void getUserDatafromWeb()
    {
        EndPoints endPoints = ApiClient.getClient().create(EndPoints.class);
        Call<UserResponceModel> call= endPoints.getAllUsers();

        call.enqueue(new Callback<UserResponceModel>() {
            @Override
            public void onResponse(Call<UserResponceModel> call, Response<UserResponceModel> response) {
                if(response.body().getStatusCode() == 200 && response.body().getStatusMessage().equals("success"))
                {
                   List<userEntity> userEntities= response.body().getData();
                   insertindb(userEntities);
                }
            }
            @Override
            public void onFailure(Call<UserResponceModel> call, Throwable t) {

            }
        });

    }
    private void insertindb(List<userEntity> userList) {
        new task(mDatabase).execute(userList);

    }

    static class task extends AsyncTask<List<userEntity>,Void,Void>{

        AppDatabase appDatabase;
        public task(AppDatabase database) {
            appDatabase=database;
        }

        @Override
        protected Void doInBackground(List<userEntity>... lists) {
            appDatabase.userDao().deleteAll();
            appDatabase.userDao().insertUsers(lists[0]);
            return null;
        }
    }
   public LiveData<List<userEntity>> loadListfromdb()
  {
        return mDatabase.userDao().selectnames();
  }

  public LiveData<userEntity> getuser(int productID){
        return mDatabase.userDao().getuser(productID);
  }

}
