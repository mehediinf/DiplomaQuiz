package com.mtech.myapplication;

public class HistoryItem {
    private final String title;
    private final String date;

    public HistoryItem(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
}
