package com.example.room_demo_sk;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Notes")
public class DemoEntity {

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name = "notestable")
    private String note;

    public DemoEntity(String id, @NonNull String note) {
        this.id = id;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    @NonNull
    public String getNote() {
        return note;
    }

}
