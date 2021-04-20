package com.example.timedriver.database.asks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.timedriver.database.code.AppDatabase;
import com.example.timedriver.database.code.RoomTask;
import com.example.timedriver.database.code.RoomTaskDao;

import java.util.ArrayList;
import java.util.List;

public class AcynkAsk_All extends AsyncTask<Void, Void, ArrayList<RoomTask>> {

    private Context mContext;

    public AcynkAsk_All (Context context){
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        Log.wtf("AcyncTask All started", "");

    }

    @Override
    protected ArrayList<RoomTask> doInBackground(Void... voids) {
        AppDatabase db = AppDatabase.getInstance(mContext);
        RoomTaskDao dao = db.RoomTaskDao();
        ArrayList<RoomTask> ans = (ArrayList<RoomTask>)dao.getAllPersons();
        Log.wtf("AcyncTask finished with ans.size() = ", String.valueOf(ans.size()));
        return ans;
    }

    @Override
    protected  void onPostExecute(ArrayList<RoomTask> result) {
        super.onPostExecute(result);
        Log.wtf("Done ans.size() =  ", String.valueOf(result.size()));
    }
}
