package src;

import java.io.*;
import java.util.*;

public class DataHandler {
    private static final String FILE_NAME = "students.txt";

    public static void saveStudents(List<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                StringBuilder line = new StringBuilder(s.getId() + "," + s.getName());
                for (Course c : s.getCourses()) {
                    line.append(",").append(c.getCourseName()).append(":").append(c.getScore());
                }
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static List<Student> loadStudents() {
        List<Student> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length >= 2) {
                    Student s = new Student(parts[0], parts[1]);
                    for (int i = 2; i < parts.length; i++) {
                        String[] cData = parts[i].split(":");
                        if (cData.length == 2) {
                            s.addCourse(new Course(cData[0], Double.parseDouble(cData[1])));
                        }
                    }
                    list.add(s);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return list;
    }
}