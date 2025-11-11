package codeAlpha;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");

        while (true) {
            System.out.print("\nEnter student name (or 'exit' to finish): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter grade for " + name + ": ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            students.add(new Student(name, grade));
        }

        if (students.isEmpty()) {
            System.out.println("No student data entered!");
            return;
        }

        double total = 0, highest = Double.MIN_VALUE, lowest = Double.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        for (Student s : students) {
            total += s.grade;
            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }
            if (s.grade < lowest) {
                lowest = s.grade;
                lowStudent = s.name;
            }
        }

        double average = total / students.size();

        System.out.println("\n=== Grade Summary ===");
        System.out.println("Total Students: " + students.size());
        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest + " (" + topStudent + ")");
        System.out.println("Lowest Grade: " + lowest + " (" + lowStudent + ")");

        System.out.println("\n=== All Student Grades ===");
        for (Student s : students) {
            System.out.println(s.name + " - " + s.grade);
        }

        scanner.close();
    }
}
