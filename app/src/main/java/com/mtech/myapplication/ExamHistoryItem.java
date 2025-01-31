package com.mtech.myapplication;

import org.json.JSONArray;

public class ExamHistoryItem {
    private final String examName;
    private final String examDate;
    private final JSONArray results;

    public ExamHistoryItem(String examName, String examDate, JSONArray results) {
        this.examName = examName;
        this.examDate = examDate;
        this.results = results;
    }

    public String getExamName() {
        return examName;
    }

    public String getExamDate() {
        return examDate;
    }

    public JSONArray getResults() {
        return results;
    }
}
