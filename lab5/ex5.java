package lab5;
import java.io.*;
import java.util.*;

public class ex5 {

    static final String TEACHER_FILE = "teacher.txt";
    static final String STUDENT_FILE = "student.txt";
    static final String GUARD_FILE = "securityguard.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Menu ===");
            System.out.println("1.   View all");
            System.out.println("2.   Add new");
            System.out.println("3.   Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: viewAll(); break;
                case 2: addNew(scanner); break;
                case 3: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 3);

        scanner.close();
    }

    // ── VIEW ALL ──────────────────────────────────────────────
    static void viewAll() {
        System.out.println("\n==== Teacher ====");
        printFile(TEACHER_FILE);

        System.out.println("\n=========== Student ===========");
        printFile(STUDENT_FILE);

        System.out.println("\n=========== Security guard ===========");
        printFile(GUARD_FILE);
    }

    static void printFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) { System.out.println("  (no records)"); return; }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(i++ + ". " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading " + filename + ": " + e.getMessage());
        }
    }

    // ── ADD NEW ───────────────────────────────────────────────
    static void addNew(Scanner scanner) {
        System.out.println("\n==== Add new resource ====");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.println("3. Security guard");
        System.out.print("Choose an opt: ");
        int opt = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (opt) {
            case 1: addTeacher(scanner); break;
            case 2: addStudent(scanner); break;
            case 3: addGuard(scanner); break;
            default: System.out.println("Invalid option.");
        }
    }

    // ── TEACHER ───────────────────────────────────────────────
    static void addTeacher(Scanner scanner) {
        System.out.print("First Name: "); String firstName = scanner.nextLine();
        System.out.print("Last Name: ");  String lastName  = scanner.nextLine();
        System.out.print("Sex: ");        String sex       = scanner.nextLine();
        System.out.print("Email: ");      String email     = scanner.nextLine();
        System.out.print("Subject: ");    String subject   = scanner.nextLine();
        System.out.print("Salary: ");     String salary    = scanner.nextLine();

        String record = String.format("[%s %s][%s][%s][%s][%s$]",
                firstName, lastName, sex, email, subject, salary);
        appendToFile(TEACHER_FILE, record);
        System.out.println("Teacher added successfully.");
    }

    // ── STUDENT ───────────────────────────────────────────────
    static void addStudent(Scanner scanner) {
        System.out.print("First Name: "); String firstName = scanner.nextLine();
        System.out.print("Last Name: ");  String lastName  = scanner.nextLine();
        System.out.print("Sex: ");        String sex       = scanner.nextLine();
        System.out.print("Email: ");      String email     = scanner.nextLine();
        System.out.print("Year: ");       String year      = scanner.nextLine();
        System.out.print("Major: ");      String major     = scanner.nextLine();

        String record = String.format("[%s %s][%s][%s][%s][%s]",
                firstName, lastName, sex, email, year, major);
        appendToFile(STUDENT_FILE, record);
        System.out.println("Student added successfully.");
    }

    // ── SECURITY GUARD ────────────────────────────────────────
    static void addGuard(Scanner scanner) {
        System.out.print("First Name: "); String firstName = scanner.nextLine();
        System.out.print("Last Name: ");  String lastName  = scanner.nextLine();
        System.out.print("Sex: ");        String sex       = scanner.nextLine();
        System.out.print("Email: ");      String email     = scanner.nextLine();
        System.out.print("Position: ");   String position  = scanner.nextLine();

        String record = String.format("[%s %s][%s][%s][%s]",
                firstName, lastName, sex, email, position);
        appendToFile(GUARD_FILE, record);
        System.out.println("Security guard added successfully.");
    }

    // ── FILE HELPER ───────────────────────────────────────────
    static void appendToFile(String filename, String record) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(record);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving to " + filename + ": " + e.getMessage());
        }
    }
}
