package com.example.demoapp.room;

import androidx.room.Entity;
import androidx.room.Ignore;

import com.example.demoapp.model.User;

@Entity(tableName = "UserTB")
public class userEntity implements User {

    private String userName
            ,userEmail
            ,userMobNum
            ,userPhoto;


    @Ignore
    public userEntity(String userName, String userEmail, String userMobNum, String userPhoto) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userMobNum = userMobNum;
        this.userPhoto = userPhoto;
    }

    public userEntity(User user) {
        this.userName = user.getUserName();
        this.userEmail = user.getUserEmail();
        this.userMobNum = user.getUserMobNum();
        this.userPhoto = user.getUserPhoto();
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserMobNum(String userMobNum) {
        this.userMobNum = userMobNum;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getUserEmail() {
        return this.userEmail;
    }

    @Override
    public String getUserMobNum() {
        return this.userMobNum;
    }

    @Override
    public String getUserPhoto() {
        return this.userPhoto;
    }
}
