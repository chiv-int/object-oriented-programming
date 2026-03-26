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
}

public class ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        boolean addMore = true;   // ← start as true so loop runs immediately
        int count = 1;

        while (addMore) {
            System.out.println("Student #" + count + ":");

            System.out.print("Id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            Student s = new Student();
            s.setValues(id, name, age);
            students.add(s);
            count++;

            System.out.print("\nDo you want to add more (y/n)?: ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("n")) {
                addMore = false;  // ← flip to false → loop stops
            }

            System.out.println();
        }

        // ─── Print table AFTER loop ends ─────────────────
        String line = "==========================================";
        System.out.println(line);
        System.out.printf("| %-10s | %-6s | %-14s | %-5s |%n",
                          "No", "ID", "Name", "Age");
        System.out.println(line);

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.printf("| %-10d | %-6d | %-14s | %-5d |%n",
                              (i + 1), s.id, s.name, s.age);
        }

        System.out.println(line);
        sc.close();
    }
}