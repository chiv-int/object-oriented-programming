package lab5;
import java.io.*;
import java.util.*;

public class ex4 {
    private static final String FILE_NAME = "data.txt";
    private static List<String> lines = new ArrayList<>();

    public static void main(String[] args) {
        loadFromFile();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Menu ===");
            System.out.println("1.  View my note");
            System.out.println("2.  Edit");
            System.out.println("3.  Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewNote();
                    break;
                case 2:
                    editNote(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void viewNote() {
        System.out.println("\n==== View note ====");
        printLines();
    }

    private static void editNote(Scanner scanner) {
        System.out.println("\n==== Edit following note ====");
        printLines();

        System.out.println("1.   Append new line");
        System.out.println("2.   Update at line");
        System.out.println("3.   Delete line");
        System.out.print("Choose an opt: ");
        int opt = scanner.nextInt();

        switch (opt) {
            case 1:
                appendLine(scanner);
                break;
            case 2:
                updateLine(scanner);
                break;
            case 3:
                deleteLine(scanner);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void appendLine(Scanner scanner) {
        int newLineNum = lines.size() + 1;
        System.out.print("Input a string for line #" + newLineNum + ": ");
        scanner.nextLine(); // consume leftover newline
        String text = scanner.nextLine();
        lines.add(text);
        saveToFile();
        System.out.println("Line #" + newLineNum + " is appended to the note.");
    }

    private static void updateLine(Scanner scanner) {
        System.out.print("Update line number: ");
        int lineNum = scanner.nextInt();
        if (lineNum < 1 || lineNum > lines.size()) {
            System.out.println("Invalid line number.");
            return;
        }
        System.out.print("Input a new string for line #" + lineNum + ": ");
        scanner.nextLine();
        String text = scanner.nextLine();
        lines.set(lineNum - 1, text);
        saveToFile();
        System.out.println("Line #" + lineNum + " is updated.");
    }

    private static void deleteLine(Scanner scanner) {
        System.out.print("Delete line number: ");
        int lineNum = scanner.nextInt();
        if (lineNum < 1 || lineNum > lines.size()) {
            System.out.println("Invalid line number.");
            return;
        }
        lines.remove(lineNum - 1);
        saveToFile();
        System.out.println("Line #" + lineNum + " is deleted.");
    }

    private static void printLines() {
        System.out.println("****************************");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + "| " + lines.get(i));
        }
        System.out.println("****************************");
    }

    private static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}