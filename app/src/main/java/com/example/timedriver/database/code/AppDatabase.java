package com.example.timedriver.database.code;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.timedriver.database.code.RoomTask;
import com.example.timedriver.database.code.RoomTaskDao;

@Database(entities = {RoomTask.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RoomTaskDao RoomTaskDao();

    private static AppDatabase instance;

    // Use this to call on any place
    public static AppDatabase getInstance(Context context) {
        return instance;
    }

    // Use once to Create and setup the object
    public static AppDatabase setInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "Task").build();
                }
            }
        }
        return instance;
    }
}

