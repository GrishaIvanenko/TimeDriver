package com.example.timedriver.ui.home;



import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.timedriver.R;
import com.example.timedriver.database.asks.AcynkAsk_Add;
import com.example.timedriver.database.asks.AcynkAsk_All;
import com.example.timedriver.database.code.AppDatabase;
import com.example.timedriver.database.code.RoomTask;
import com.example.timedriver.database.code.RoomTaskDao;
import com.example.timedriver.decor.recyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class HomeFragment extends Fragment {
    private AppDatabase db;
    ArrayList<RoomTask> cash;
    private RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        AcynkAsk_All getter = new AcynkAsk_All(this.getContext());
        getter.execute();
        try {
            cash = getter.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        recyclerView = root.findViewById(R.id.recyclerView1);
        setAdapter();
        return root;
    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(cash);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}