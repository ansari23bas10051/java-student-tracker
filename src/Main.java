package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = DataHandler.loadStudents();

        while (true) {
            System.out.println("\n--- STUDENT TRACKER CLI ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course & Grade to Student");
            System.out.println("3. View Student Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter Student ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter Student Name: ");
                String name = scanner.nextLine();
                students.add(new Student(id, name));
                DataHandler.saveStudents(students);
                System.out.println("Student added successfully!");
            } else if (choice == 2) {
                System.out.print("Enter Student ID: ");
                String id = scanner.nextLine();
                Student found = null;
                for (Student s : students) {
                    if (s.getId().equals(id)) { found = s; break; }
                }
                if (found != null) {
                    System.out.print("Enter Course Name: ");
                    String cName = scanner.nextLine();
                    System.out.print("Enter Marks (0-100): ");
                    double score = scanner.nextDouble();
                    found.addCourse(new Course(cName, score));
                    DataHandler.saveStudents(students);
                    System.out.println("Course added!");
                } else {
                    System.out.println("Student not found!");
                }
            } else if (choice == 3) {
                for (Student s : students) {
                    System.out.println("\nID: " + s.getId() + " | Name: " + s.getName());
                    for (Course c : s.getCourses()) {
                        System.out.println("  - " + c.getCourseName() + ": " + c.getScore() + " (" + c.getGrade() + ")");
                    }
                    System.out.println("  Average Score: " + GradeCalculator.calculateGPA(s.getCourses()));
                }
            } else if (choice == 4) {
                System.out.println("Exiting program...");
                break;
            }
        }
        scanner.close();
    }
}