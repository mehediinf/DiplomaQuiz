package com.mtech.myapplication;

public class Student {

    private String name;        // স্টুডেন্টের নাম
    private String department;  // বিভাগ
    private int score;          // স্কোর
    private int imageResId;     // ইমেজ রিসোর্স আইডি

    public Student(String name, String department, int score, int imageResId) {
        this.name = name;
        this.department = department;
        this.score = score;
        this.imageResId = imageResId;
    }

    // গেটার মেথড
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getScore() {
        return score;
    }

    public int getImageResId() {
        return imageResId;
    }

    // সেটার মেথড (যদি প্রয়োজন হয়)
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
