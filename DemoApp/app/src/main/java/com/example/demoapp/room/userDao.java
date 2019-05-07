package com.example.demoapp.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;

import java.util.List;

@Dao
public interface userDao {
    @Insert
    void insertUsers(List<userEntity> userEntities);

    @Query("DELETE from usertb")
    void deleteAll();

    @Query("SELECT user_display_name, ID from usertb")
    LiveData<List<userEntity>> selectnames();
}
