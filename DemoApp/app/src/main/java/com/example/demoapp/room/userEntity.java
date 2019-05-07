package com.example.demoapp.room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.demoapp.model.User;

@Entity(tableName = "UserTB")
public class userEntity implements User {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int ID;
    private String user_display_name;
    private String user_email;
    private String user_photo;
    private String user_mob_num;


    public userEntity(String user_display_name, String user_email, String user_photo, String user_mob_num) {
        this.user_display_name = user_display_name;
        this.user_email = user_email;
        this.user_photo = user_photo;
        this.user_mob_num = user_mob_num;
    }

    public userEntity(User user) {
        this.user_display_name = user.getUser_display_name();
        this.user_email = user.getUser_email();
        this.user_photo = user.getUser_photo();
        this.user_mob_num = user.getUser_mob_num();
        this.ID=user.getID();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUser_display_name(String user_display_name) {
        this.user_display_name = user_display_name;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public void setUser_mob_num(String user_mob_num) {
        this.user_mob_num = user_mob_num;
    }

    @Override
    public String getUser_display_name() {
        return this.user_display_name;
    }

    @Override
    public String getUser_email() {
        return this.user_email;
    }

    @Override
    public String getUser_photo() {
        return this.user_photo;
    }

    @Override
    public String getUser_mob_num() {
        return this.user_mob_num;
    }


}
