package com.example.timedriver.database.asks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.timedriver.database.code.AppDatabase;
import com.example.timedriver.database.code.RoomTaskDao;

public class AcynkAsk_Del extends AsyncTask<Void, Void, Void> {

    private Context mContext;

    public AcynkAsk_Del (Context context){
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        Log.wtf("AcyncTask Del started", "");

    }

    @Override
    protected Void doInBackground(Void... voids) {
        AppDatabase db = AppDatabase.getInstance(mContext);
        RoomTaskDao dao = db.RoomTaskDao();
        dao.deleteAll();
        Log.wtf("AcyncTask finished", "");
        return null;
    }

}
