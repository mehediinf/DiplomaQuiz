package com.mtech.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ExamResultsAdapter extends RecyclerView.Adapter<ExamResultsAdapter.ViewHolder> {

    private final List<String> resultsList;

    public ExamResultsAdapter(List<String> resultsList) {
        this.resultsList = resultsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exam_result, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String result = resultsList.get(position);
        holder.resultTextView.setText(result);
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView resultTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            resultTextView = itemView.findViewById(R.id.tv_result);
        }
    }
}
