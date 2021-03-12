package com.lab11.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Subject> subject;
    private int average;
    private String firstname;
    private String lastname;
    private String groupnumber;


    public List<Subject> getSubject() {
        if (subject == null) {
            subject = new ArrayList<Subject>();
        }
        return this.subject;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int value) {
        this.average = value;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String value) {
        this.firstname = value;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String value) {
        this.lastname = value;
    }

    public String getGroupnumber() {
        return groupnumber;
    }

    public void setGroupnumber(String value) {
        this.groupnumber = value;
    }

    @Override
    public String toString() {
        return "Student{" +
                "subject=" + subject +
                ", average=" + average +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", groupnumber='" + groupnumber + '\'' +
                '}';
    }
}
