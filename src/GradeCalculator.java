package src;

import java.util.List;

public class GradeCalculator {
    public static double calculateGPA(List<Course> courses) {
        if (courses.isEmpty()) return 0.0;
        double total = 0;
        for (Course c : courses) {
            total += c.getScore();
        }
        return total / courses.size();
    }
}