package lab04;

import java.util.Scanner;

public class ex02 {
    static int[] ids = new int[100];
    static String[] names = new String[100];
    static int[] ages = new int[100];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("==== Menu ===");
            System.out.println("1.  View all students");
            System.out.println("2.  Add a new student");
            System.out.println("3.  Delete a student");
            System.out.println("4.  Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    viewStudents();
                    break;
                case 2:
                    addStudent(scanner);
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
            System.out.println();
        } while (choice != 4);

        scanner.close();
    }

    static void viewStudents() {
        if (count == 0) {
            System.out.println("No students found.");
            return;
        }
        String line = "=".repeat(45);
        System.out.println(line);
        System.out.printf("| %-8s| %-8s| %-12s| %-6s|%n", "No", "ID", "Name", "Age");
        System.out.println(line);
        for (int i = 0; i < count; i++) {
            System.out.printf("| %-8d| %-8d| %-12s| %-6d|%n", i + 1, ids[i], names[i], ages[i]);
        }
        System.out.println(line);
    }

    static void addStudent(Scanner scanner) {
        System.out.println("==== Add a new student ====");
        System.out.print("Id: ");
        ids[count] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        names[count] = scanner.nextLine();
        System.out.print("Age: ");
        ages[count] = scanner.nextInt();
        scanner.nextLine();
        count++;
        System.out.println("Student added successfully.");
    }

    static void deleteStudent(Scanner scanner) {
        System.out.println("==== Delete a student ====");
        int targetId;
        int foundIndex = -1;

        while (foundIndex == -1) {
            System.out.print("Input student ID: ");
            targetId = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < count; i++) {
                if (ids[i] == targetId) {
                    foundIndex = i;
                    break;
                }
            }

            if (foundIndex == -1) {
                System.out.println("Student is not found. Try again");
            }
        }

        
        System.out.println("The following student has been deleted.");
        System.out.printf("| %-8d| %-8d| %-12s| %-6d|%n",
                foundIndex + 1, ids[foundIndex], names[foundIndex], ages[foundIndex]);

        
        for (int i = foundIndex; i < count - 1; i++) {
            ids[i] = ids[i + 1];
            names[i] = names[i + 1];
            ages[i] = ages[i + 1];
        }
        count--;
    }
}