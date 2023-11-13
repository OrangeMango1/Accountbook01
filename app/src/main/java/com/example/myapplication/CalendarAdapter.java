package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ItemView> {
    private Context context;
    private static ArrayList<Long> array = new ArrayList<>();
    private static int month = 0;

    public CalendarAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent, false);
        return new ItemView(view);
    }

    @Override
    public void onBindViewHolder(ItemView holder, int position) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(array.get(position));
        int month = calendar.get(Calendar.MONTH);
        if (this.month != month) {
            holder.background.setBackgroundColor(Color.parseColor("#44cccccc"));
        } else {
            holder.background.setBackgroundColor(Color.WHITE);
        }
        holder.textDay.setText(new SimpleDateFormat("dd").format(calendar.getTime()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public void setList(ArrayList<Long> array, int month) {
        this.month = month;
        this.array.clear();
        this.array.addAll(array);
        notifyDataSetChanged();
    }

    public static class ItemView extends RecyclerView.ViewHolder {
        TextView textDay;
        ConstraintLayout background;

        public ItemView(View view) {
            super(view);
            textDay = view.findViewById(R.id.text_day);
            background = view.findViewById(R.id.background);
        }
    }
}
