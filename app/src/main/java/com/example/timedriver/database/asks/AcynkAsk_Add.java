package com.example.timedriver.database.asks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.widget.Toast;

import com.example.timedriver.database.code.AppDatabase;
import com.example.timedriver.database.code.RoomTask;
import com.example.timedriver.database.code.RoomTaskDao;

import java.util.ArrayList;
import java.util.List;

public class AcynkAsk_Add extends AsyncTask<RoomTask, Void, Void> {

    private Context mContext;

    public AcynkAsk_Add (Context context){
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        Log.wtf("AcyncTask Add started ", "");
    }

    @Override
    protected Void doInBackground(RoomTask... roomTasks) {
        AppDatabase db = AppDatabase.getInstance(mContext);
        RoomTaskDao dao = db.RoomTaskDao();
        Log.wtf(" ADDED ", roomTasks[0].getDescription());
        dao.Insert(roomTasks[0]);
        return null;
    }

}
