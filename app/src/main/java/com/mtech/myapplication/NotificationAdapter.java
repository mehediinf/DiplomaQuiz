package com.mtech.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private final Context context;
    private final List<Notification> notificationList; // Updated to use a Notification class

    public NotificationAdapter(Context context, List<Notification> notificationList) {
        this.context = context;
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Notification notification = notificationList.get(position);

        // Set the title to the RecyclerView item
        holder.tvSerial.setText(String.format("%02d.", position + 1)); // Serial number
        holder.tvNotificationTitle.setText(notification.getTitle());   // Title text

        // Handle item click to show details in a dialog
        holder.itemView.setOnClickListener(v -> showDialog(notification.getTitle(), notification.getDetails()));
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    // Method to show the dialog with details
    private void showDialog(String title, String details) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);  // Set the title of the dialog
        builder.setMessage(details); // Show the details text

        // Add a "Close" button to the dialog
        builder.setPositiveButton("Close", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSerial, tvNotificationTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSerial = itemView.findViewById(R.id.tvSerial);
            tvNotificationTitle = itemView.findViewById(R.id.tvNotificationTitle);
        }
    }
}
