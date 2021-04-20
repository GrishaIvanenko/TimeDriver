package com.example.timedriver.ui.dashboard;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.timedriver.R;
import com.example.timedriver.database.asks.AcynkAsk_Add;
import com.example.timedriver.database.asks.AcynkAsk_Del;
import com.example.timedriver.database.code.RoomTask;

public class DashboardFragment extends Fragment {
    private EditText editText;
    private  Button button;
    private  Button delet;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        editText = root.findViewById(R.id.editdescription);
        button = root.findViewById(R.id.button);
        delet = root.findViewById(R.id.button_deleter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                Log.wtf("MAKING TASK ", s);
                RoomTask roomTask = new RoomTask(s);
                AcynkAsk_Add tmp = new AcynkAsk_Add(getContext());
                tmp.execute(roomTask);
                return;
            }
        });
        delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AcynkAsk_Del tmp = new AcynkAsk_Del(getContext());
                tmp.execute();
                return;
            }
        });
        return root;
    }
}