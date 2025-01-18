package com.mtech.myapplication;

public class Notification {
    private final String title;
    private final String details;

    public Notification(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }
}
