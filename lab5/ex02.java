package lab5;
import java.util.ArrayList;
import java.util.Scanner;
class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class ex02 {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudents() {
        int count = 1;
        String more = "y";

        while (more.equalsIgnoreCase("y")) {
            System.out.println("Student #" + count + ":");
            System.out.print("Id: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Name: ");
            String name = sc.nextLine().trim();
            System.out.print("Age: ");
            int age = Integer.parseInt(sc.nextLine().trim());

            students.add(new Student(id, name, age));
            count++;

            System.out.print("\nDo you want to add more (y/n)?: ");
            more = sc.nextLine().trim();
        }
    }

    public static void printTable() {
        String line = "=".repeat(63);
        System.out.println(line);
        System.out.printf("| %-10s | %-10s | %-25s | %-8s |\n", "No", "ID", "Name", "Age");
        System.out.println(line);
        int no = 1;
        for (Student s : students) {
            System.out.printf("| %-10d | %-10d | %-25s | %-8d |\n", no++, s.id, s.name, s.age);
        }
        System.out.println(line);
    }

    public static void deleteMultiple() {
        if (students.isEmpty()) {
            System.out.println("No students to delete.");
            return;
        }

        printTable();

        ArrayList<Integer> idsToDelete = new ArrayList<>();
        int count = 1;
        String more = "y";

        System.out.println("==== DELETION =====");
        while (more.equalsIgnoreCase("y")) {
            System.out.print("Input student #" + count + " ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            idsToDelete.add(id);
            count++;
            System.out.print("Do you want to delete more (y/n)?: ");
            more = sc.nextLine().trim();
        }

        System.out.println();
        for (int id : idsToDelete) {
            boolean found = students.removeIf(s -> s.id == id);
            if (found) {
                System.out.println("Student with ID " + id + " deleted");
            } else {
                System.out.println("Student with ID " + id + " not found!");
            }
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== Menu ===");
            System.out.println("1.   Add new students");
            System.out.println("2.   Delete multiple students");
            System.out.println("3.   Quit");
            System.out.print("Choose an opt: ");

            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1: addStudents(); break;
                case 2: deleteMultiple(); break;
                case 3: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid option. Please choose 1-3.");
            }
        } while (choice != 3);

        sc.close();
    }
}
