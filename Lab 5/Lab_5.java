import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Student {
    String regNo;
    String name;
    String email;
    String phone;
    String class_;
    String department;

    public Student(String regNo, String name, String email, String phone, String class_, String department) {
        this.regNo = regNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.class_ = class_;
        this.department = department;
    }

    public void printDetails() {
        System.out.println("Reg. No.: " + regNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Class: " + class_);
        System.out.println("Department: " + department);
    }

    public void saveToFile() {
        String fileName = name + ".txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Reg. No.: " + regNo + "\n");
            writer.write("Name: " + name + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Phone: " + phone + "\n");
            writer.write("Class: " + class_ + "\n");
            writer.write("Department: " + department + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the details to file.");
            e.printStackTrace();
        }
    }
}

public class Lab_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[100];
        int numOfStudents = 0;
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a student");
            System.out.println("2. Search for a student");
            System.out.println("3. Display all students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter the student's registration number: ");
                    String regNo = scanner.nextLine();
                    System.out.print("Enter the student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the student's email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter the student's phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter the student's class: ");
                    String class_ = scanner.nextLine();
                    System.out.print("Enter the student's department: ");
                    String department = scanner.nextLine();
                    Student student = new Student(regNo, name, email, phone, class_, department);
                    students[numOfStudents] = student;
                    numOfStudents++;
                    student.saveToFile();
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.print("Enter the name or registration number of the student to search for: ");
                    String searchKey = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < numOfStudents; i++) {
                        Student s = students[i];
                        if (s.name.equals(searchKey) || s.regNo.equals(searchKey)) {
                            s.printDetails();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                }
            }
        }
    }