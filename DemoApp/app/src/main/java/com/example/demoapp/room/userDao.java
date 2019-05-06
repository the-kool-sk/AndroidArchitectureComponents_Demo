package com.example.demoapp.room;

import androidx.room.Dao;
import androidx.room.Insert;

import java.util.List;

@Dao
public interface userDao {
    @Insert
    void insertUsers(List<userEntity> userEntities);
}
