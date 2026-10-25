package com.internship.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapImplementation {
    private static final Map<String, Double> studentGrades = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("\n=== Student Grade Management ===");
                System.out.println("1. Add student grade");
                System.out.println("2. Retrieve student grade");
                System.out.println("3. Update student grade");
                System.out.println("4. Display all student grades");
                System.out.println("5. Remove student");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        addStudent(scanner);
                        break;
                    case "2":
                        retrieveGrade(scanner);
                        break;
                    case "3":
                        updateGrade(scanner);
                        break;
                    case "4":
                        displayAllGrades();
                        break;
                    case "5":
                        removeStudent(scanner);
                        break;
                    case "6":
                        running = false;
                        System.out.println("Program closed.");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose from 1 to 6.");
                }
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Student name cannot be empty.");
            return;
        }

        if (studentGrades.containsKey(name)) {
            System.out.println("Student already exists. Use the update option to change the grade.");
            return;
        }

        Double grade = readGrade(scanner);
        if (grade != null) {
            studentGrades.put(name, grade);
            System.out.println("Student grade added successfully.");
        }
    }

    private static void retrieveGrade(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (studentGrades.containsKey(name)) {
            System.out.printf("%s's grade: %.2f%n", name, studentGrades.get(name));
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateGrade(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (!studentGrades.containsKey(name)) {
            System.out.println("Student not found.");
            return;
        }

        Double grade = readGrade(scanner);
        if (grade != null) {
            studentGrades.put(name, grade);
            System.out.println("Student grade updated successfully.");
        }
    }

    private static void displayAllGrades() {
        if (studentGrades.isEmpty()) {
            System.out.println("No student grades available.");
            return;
        }

        System.out.println("\nStudent Grades:");
        for (Map.Entry<String, Double> entry : studentGrades.entrySet()) {
            System.out.printf("%s : %.2f%n", entry.getKey(), entry.getValue());
        }
    }

    private static void removeStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (studentGrades.remove(name) != null) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Double readGrade(Scanner scanner) {
        System.out.print("Enter grade (0-100): ");
        String input = scanner.nextLine().trim();

        try {
            double grade = Double.parseDouble(input);
            if (grade < 0 || grade > 100) {
                System.out.println("Grade must be between 0 and 100.");
                return null;
            }
            return grade;
        } catch (NumberFormatException exception) {
            System.out.println("Please enter a valid numeric grade.");
            return null;
        }
    }
}
