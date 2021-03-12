package com.lab11.model;

public class Verifier {
    public static void changeAverageScoreIfIncorrect(Group group) {
        for (Student student : group.getStudents()) {
            int averageScore = getAverageScore(student);
            if (averageScore != student.getAverage()) {
                student.setAverage(averageScore);
            }
        }
    }

    private static int getAverageScore(Student student) {
        int totalSum = 0;
        for (Subject subject : student.getSubject()) {
            totalSum += subject.getMark();
        }
        return totalSum / student.getSubject().size();
    }
}
