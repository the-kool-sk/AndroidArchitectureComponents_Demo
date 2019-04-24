package com.example.room_demo_sk;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;


@Database(entities = DemoEntity.class,version = 1)
public abstract class DemoAppDB extends RoomDatabase {

    private static volatile DemoAppDB INSTANCE;
    public abstract DemoDAO demoDAO();
    static DemoAppDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DemoAppDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DemoAppDB.class, "note_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
