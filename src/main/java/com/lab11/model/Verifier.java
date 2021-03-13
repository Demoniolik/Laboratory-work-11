package com.lab11.model;

public class Verifier {
    public static void changeAverageScoreIfIncorrect(Group group) {
        group.getStudents().forEach(student -> {
            int averageScore = getAverageScore(student);
            if (student.getAverage() != averageScore) {
                student.setAverage(averageScore);
            }
        });
    }

    private static int getAverageScore(Student student) {
        int totalSum = student.getSubject()
                .stream()
                .map(Subject::getMark)
                .mapToInt(element -> element)
                .sum();
        return totalSum / student.getSubject().size();
    }
}
