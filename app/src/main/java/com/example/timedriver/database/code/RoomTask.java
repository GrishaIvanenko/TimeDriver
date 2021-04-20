package com.example.timedriver.database.code;

import android.util.EventLogTags;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Task")
public class RoomTask {
    @PrimaryKey(autoGenerate =  true)
    int id;
    @ColumnInfo(name = "Description")
    String description;
    @ColumnInfo(name = "Priority")
    int priority;
    /*@ColumnInfo(name = "HashTags")
    List<String> HashTags;
    @ColumnInfo(name = "Time")
    int time;*/

    /*@Ignore
    public com.example.timedriver.RoomTask(String description, int priority, int time, List<String> HashTags) {
        this.description = description;
        this.priority = priority;
        this.time = time;
        this.HashTags = HashTags;
    }
    @Ignore
    public com.example.timedriver.RoomTask(String description, int priority, int time) {
        this.description = description;
        this.priority = priority;
        this.time = time;
        this.HashTags = new List<>();
    }

    @Ignore
    public com.example.timedriver.RoomTask(String description, int priority) {
        this.description = description;
        this.priority = priority;
        this.time = -1;
        this.HashTags = new List<>();
    }*/

    public RoomTask(String  description) {
        this.description = description;
        this.priority = 0;
        //this.time = -1;
        //this.HashTags = new List<>();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}