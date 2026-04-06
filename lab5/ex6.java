package lab5;
import java.io.*;
import java.util.*;

public class ex6{

    static final String USER_FILE = "user.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Menu ===");
            System.out.println("1.   Login");
            System.out.println("2.   Register");
            System.out.println("3.   Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: login(scanner); break;
                case 2: register(scanner); break;
                case 3: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 3);

        scanner.close();
    }

    // ── REGISTER ──────────────────────────────────────────────
    static void register(Scanner scanner) {
        System.out.println("\n==== Register a new user ====");
        System.out.print("First Name: "); String firstName = scanner.nextLine();
        System.out.print("Last Name: ");  String lastName  = scanner.nextLine();
        System.out.print("Username: ");   String username  = scanner.nextLine();
        System.out.print("Email: ");      String email     = scanner.nextLine();
        System.out.print("Password: ");   String password  = scanner.nextLine();

        // Save: firstName,lastName,username,email,password
        String record = firstName + "," + lastName + "," + username + "," + email + "," + password;
        appendToFile(USER_FILE, record);

        System.out.println("\nYou are successfully registered~");
    }

    // ── LOGIN ─────────────────────────────────────────────────
    static void login(Scanner scanner) {
        System.out.println("\n==== Login ====");

        while (true) {
            System.out.print("Email or Username: "); String input    = scanner.nextLine();
            System.out.print("Password: ");          String password = scanner.nextLine();

            String[] user = findUser(input, password);

            if (user == null) {
                System.out.println("User not found. Please try again\n");
            } else {
                // user[]: firstName, lastName, username, email, password
                System.out.println("=========== User Info ===========");
                System.out.println("Hi " + user[0] + " " + user[1] + ",");
                System.out.println("Your username is: " + user[2]);
                System.out.println("Your email is: " + user[3]);
                break;
            }
        }
    }

    // ── FIND USER ─────────────────────────────────────────────
    // Returns user fields if email/username AND password match, else null
    static String[] findUser(String input, String password) {
        File file = new File(USER_FILE);
        if (!file.exists()) return null;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 5);
                if (parts.length < 5) continue;

                String firstName = parts[0];
                String lastName  = parts[1];
                String username  = parts[2];
                String email     = parts[3];
                String pass      = parts[4];

                boolean matchIdentifier = username.equalsIgnoreCase(input)
                                       || email.equalsIgnoreCase(input);
                boolean matchPassword   = pass.equals(password);

                if (matchIdentifier && matchPassword) {
                    return new String[]{firstName, lastName, username, email, pass};
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return null;
    }

    // ── FILE HELPER ───────────────────────────────────────────
    static void appendToFile(String filename, String record) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(record);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}