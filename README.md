# Java Learning Repository

![Java Logo](https://www.oracle.com/a/tech/img/cb88-java-logo-001.jpg)

## Introduction

Welcome to the Java Learning Repository! This repository is designed to help you learn Java programming through a series of practical problems and solutions. Whether you are a beginner or an experienced programmer looking to sharpen your skills, you will find valuable resources here.

## About This Repository

This repository contains a collection of Java programming problems, each accompanied by a detailed solution. The problems cover a wide range of topics, from basic syntax and control structures to more advanced algorithms and data structures. Each problem is presented with a clear description, input and output examples, and a complete Java implementation.

### Repository Structure

The repository is organized into folders, each representing a different category of problems. Examples include:

- **Basic Syntax and Operations**
- **Algorithms**
- **Object-Oriented Programming**

## Example Problem and Solution

### Problem: Student Grade Management

Write a Java program that manages a list of students. Each student has a name and a list of grades. The program should allow the user to:

- Add a new student.
- Add grades for a student.
- Calculate and display the average grade for a student.
- Display the student with the highest average grade.

#### Example Input and Output

Welcome to the Student Manager! Available commands: add student - Add a new student add grade - Add grades for a student average grade - Display the average grade for a student highest average - Display the student with the highest average grade exit - Exit the programEnter command: add student Enter student name: Alice Student added successfully.Enter command: add grade Enter student name: Alice Enter grade: 90 Grade added successfully.Enter command: add grade Enter student name: Alice Enter grade: 85 Grade added successfully.Enter command: average grade Enter student name: Alice Average grade for Alice: 87.50Enter command: highest average Student with the highest average grade: Alice (87.50)Enter command: exit Exiting the program.### Example Java Code

```java
import java.util.*;

public class StudentManager {
    private static class Student {
        String name;
        List<Integer> grades = new ArrayList<>();

        Student(String name) {
            this.name = name;
        }

        void addGrade(int grade) {
            grades.add(grade);
        }

        double getAverageGrade() {
            return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        }
    }

    private static Map<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Student Manager!");
        System.out.println("Available commands:");
        System.out.println("add student - Add a new student");
        System.out.println("add grade - Add grades for a student");
        System.out.println("average grade - Display the average grade for a student");
        System.out.println("highest average - Display the student with the highest average grade");
        System.out.println("exit - Exit the program");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            switch (command) {
                case "add student":
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    students.put(studentName, new Student(studentName));
                    System.out.println("Student added successfully.");
                    break;
                case "add grade":
                    System.out.print("Enter student name: ");
                    studentName = scanner.nextLine();
                    Student student = students.get(studentName);
                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("Enter grade: ");
                    int grade = Integer.parseInt(scanner.nextLine());
                    student.addGrade(grade);
                    System.out.println("Grade added successfully.");
                    break;
                case "average grade":
                    System.out.print("Enter student name: ");
                    studentName = scanner.nextLine();
                    student = students.get(studentName);
                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.printf("Average grade for %s: %.2f%n", studentName, student.getAverageGrade());
                    break;
                case "highest average":
                    Student topStudent = null;
                    double highestAverage = 0.0;
                    for (Student s : students.values()) {
                        double average = s.getAverageGrade();
                        if (average > highestAverage) {
                            highestAverage = average;
                            topStudent = s;
                        }
                    }
                    if (topStudent != null) {
                        System.out.printf("Student with the highest average grade: %s (%.2f)%n", topStudent.name, highestAverage);
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }
}

Contribution 

Contributions to this repository are welcome! If you have a problem or solution you would like to add, please fork the repository and submit a pull request.
Make sure to follow the existing format for consistency.ContactIf you have any questions or suggestions, feel free to open an issue or contact the repository maintainers.

Happy coding!
