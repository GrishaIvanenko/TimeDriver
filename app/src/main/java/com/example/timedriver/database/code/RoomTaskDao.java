package com.example.timedriver.database.code;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.timedriver.database.code.RoomTask;

import java.util.List;

@Dao
public interface RoomTaskDao {
    @Insert
    void Insert(com.example.timedriver.database.code.RoomTask roomTask);

    @Insert
    void InsertAll(List<com.example.timedriver.database.code.RoomTask> arr);

    @Delete
    void Delete(com.example.timedriver.database.code.RoomTask roomTask);

    @Query("DELETE FROM Task")
    void deleteAll();

    @Query("SELECT * FROM Task")
    List<RoomTask> getAllPersons();

    @Query("Select * FROM Task WHERE id = :id")
    List<com.example.timedriver.database.code.RoomTask> getRoomTaskWithid(int id);

    @Query("Select * FROM Task WHERE Description = :Description")
    List<com.example.timedriver.database.code.RoomTask> getRoomTaskWithid(String Description);

    @Query("Select * FROM Task WHERE Priority = :Priority")
    List<com.example.timedriver.database.code.RoomTask> getRoomTaskWithPriority(int Priority);
}