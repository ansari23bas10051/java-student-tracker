package src;

public class Course {
    private String courseName;
    private double score;

    public Course(String courseName, double score) {
        this.courseName = courseName;
        this.score = score;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getScore() {
        return score;
    }

    public String getGrade() {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }
}
