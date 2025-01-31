package com.mtech.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ExamHistoryAdapter extends RecyclerView.Adapter<ExamHistoryAdapter.ViewHolder> {

    private final List<ExamHistoryItem> examHistoryList;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ExamHistoryItem item);
    }

    public ExamHistoryAdapter(List<ExamHistoryItem> examHistoryList, OnItemClickListener listener) {
        this.examHistoryList = examHistoryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exam_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExamHistoryItem item = examHistoryList.get(position);
        holder.bind(item, listener);
    }

    @Override
    public int getItemCount() {
        return examHistoryList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView examName;
        private final TextView examDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            examName = itemView.findViewById(R.id.tv_examName);
            examDate = itemView.findViewById(R.id.tv_examDate);
        }

        public void bind(final ExamHistoryItem item, final OnItemClickListener listener) {
            examName.setText(item.getExamName());
            examDate.setText(item.getExamDate());
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }
}
