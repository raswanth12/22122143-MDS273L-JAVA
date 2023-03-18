import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

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
            System.out.println("3. Edit a student's details");
            System.out.println("4. Delete a student's record");
            System.out.println("5. Display all students");
            System.out.println("6. Exit");
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
                                         if (s.regNo.equals(searchKey) || s.name.equals(searchKey)) {
                        s.printDetails();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found.");
                }
                break;
            case 3:
                System.out.print("Enter the name or registration number of the student to edit: ");
                String editKey = scanner.nextLine();
                found = false;
                for (int i = 0; i < numOfStudents; i++) {
                    Student s = students[i];
                    if (s.regNo.equals(editKey) || s.name.equals(editKey)) {
                        System.out.print("Enter the student's new registration number (leave blank to keep the same): ");
                        String newRegNo = scanner.nextLine();
                        System.out.print("Enter the student's new name (leave blank to keep the same): ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter the student's new email (leave blank to keep the same): ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter the student's new phone number (leave blank to keep the same): ");
                        String newPhone = scanner.nextLine();
                        System.out.print("Enter the student's new class (leave blank to keep the same): ");
                        String newClass = scanner.nextLine();
                        System.out.print("Enter the student's new department (leave blank to keep the same): ");
                        String newDepartment = scanner.nextLine();
                        if (!newRegNo.isEmpty()) {
                            s.regNo = newRegNo;
                        }
                        if (!newName.isEmpty()) {
                            s.name = newName;
                        }
                        if (!newEmail.isEmpty()) {
                            s.email = newEmail;
                        }
                        if (!newPhone.isEmpty()) {
                            s.phone = newPhone;
                        }
                        if (!newClass.isEmpty()) {
                            s.class_ = newClass;
                        }
                        if (!newDepartment.isEmpty()) {
                            s.department = newDepartment;
                        }
                        s.saveToFile();
                        System.out.println("Student details updated successfully.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found.");
                }
                break;
            case 4:
                System.out.print("Enter the name or registration number of the student to delete: ");
                String deleteKey = scanner.nextLine();
                found = false;
                for (int i = 0; i < numOfStudents; i++) {
                    Student s = students[i];
                    if (s.regNo.equals(deleteKey) || s.name.equals(deleteKey)) {
                        File file = new File(s.name + ".txt");
                        file.delete();
                        for (int j = i; j < numOfStudents - 1; j++) {
                            students[j] = students[j + 1];
                        }
                        numOfStudents--;
                        System.out.println("Student deleted successfully.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found.");
                }
                break;
            case 5:
                if (numOfStudents == 0) {
                    System.out.println("No students added yet.");
                } else {
                    for (int i = 0; i < numOfStudents; i++) {
                        Student s = students[i];
                        s.printDetails();
                        System.out.println();
                    }
                }
                break;
            case 6:
                System.out.println("Exiting program.");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}}
