package com.example.timedriver.decor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timedriver.R;
import com.example.timedriver.database.code.RoomTask;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {

    private final ArrayList<RoomTask> taskArrayList;

    public recyclerAdapter(ArrayList<RoomTask> input) {
        taskArrayList = input;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView id_text;
        private final TextView description_text;

        public MyViewHolder (final View view) {
            super(view);
            id_text = view.findViewById(R.id.id_text);
            description_text = view.findViewById(R.id.description_text);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.roomtask_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        Integer id = taskArrayList.get(position).getId();
        String description = taskArrayList.get(position).getDescription();
        holder.id_text.setText(String.valueOf(id));
        holder.description_text.setText(description);
    }

    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }
}
