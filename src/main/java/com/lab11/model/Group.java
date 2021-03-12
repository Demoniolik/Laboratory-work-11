package com.lab11.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Student> students;

    public List<Student> getStudents() {
        if (students == null) {
            students = new ArrayList<Student>();
        }
        return this.students;
    }

}
