package lab03;

import java.util.Scanner;
import java.util.ArrayList;

class Student {
    int id;
    String name;
    int age;

    void setValues(int id, String name, int age) {
        this.id   = id;
        this.name = name;
        this.age  = age;
    }

    void display() {
        System.out.printf("| %-10d | %-6d | %-14s | %-5d |%n", 0, id, name, age);
    }
}

public class ex07 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1: createStudent(); break;
                case 2: listStudents();  break;
                case 3: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid option!");
            }
        } while (choice != 3);
        sc.close();
    }

    static void printMenu() {
        System.out.println("====== Menu ======");
        System.out.println("1.  Create a student");
        System.out.println("2.  List students");
        System.out.println("3.  Quit");
    }

    static void createStudent() {
        Student s = new Student();
        System.out.println("Student #" + (students.size() + 1) + ":");

        System.out.print("Id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        s.setValues(id, name, age);
        students.add(s);
        System.out.println("A student is added to the list\n");
    }

    static void listStudents() {
        String line = "=============================================";
        System.out.println(line);
        System.out.printf("| %-10s | %-6s | %-14s | %-5s |%n",
                          "No", "ID", "Name", "Age");
        System.out.println(line);

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.printf("| %-10d | %-6d | %-14s | %-5d |%n",
                              (i + 1), s.id, s.name, s.age);
        }
        System.out.println(line + "\n");
    }
}