package com.lab11.model;

public class Subject {
    private String title;
    private int mark;

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int value) {
        this.mark = value;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "title='" + title + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
