package com.mtech.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Student> studentList;
    private Context context;

    public MyAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.scoreboard_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student student = studentList.get(position);

        // SL (Serial Number) set করা
        holder.tvSL.setText(String.valueOf(position + 1));

        // Image Placeholder (studentImage)
        holder.imgStudent.setImageResource(R.drawable.user_avatar);

        // Name এবং Department set করা
        holder.tvName.setText(student.getName());
        holder.tvDepartment.setText("CSE"); // বিভাগটি ডিফল্ট হিসেবে CSE রাখা হয়েছে (এটি পরিবর্তন করা সম্ভব)

        // Score set করা
        holder.tvScore.setText(String.valueOf(student.getScore()));

        // Top 3 স্টাইল নির্ধারণ করা
        if (position == 0) {
            holder.tvName.setTypeface(null, Typeface.BOLD);
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.material_green));
        } else if (position == 1) {
            holder.tvName.setTypeface(null, Typeface.BOLD);
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.light_violet_blue));
        } else if (position == 2) {
            holder.tvName.setTypeface(null, Typeface.BOLD);
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.blue));
        } else {
            holder.tvName.setTypeface(null, Typeface.NORMAL);
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        }
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvSL, tvName, tvScore, tvDepartment;
        ImageView imgStudent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSL = itemView.findViewById(R.id.tv_SL_ID); // SL এর জন্য
            imgStudent = itemView.findViewById(R.id.studentImage); // ImageView
            tvName = itemView.findViewById(R.id.tv_StudentName); // নাম
            tvDepartment = itemView.findViewById(R.id.tv_Department); // বিভাগ
            tvScore = itemView.findViewById(R.id.tv_Score); // স্কোর
        }
    }
}
