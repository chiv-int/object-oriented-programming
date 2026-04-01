package lab04;

import java.util.Scanner;
public class ex03 {
    static int[] isbns = new int[100];
    static String[] titles = new String[100];
    static double[] prices = new double[100];
    static String[] authors = new String[100];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("==== Menu ===");
            System.out.println("1.  View all books");
            System.out.println("2.  Add a new book");
            System.out.println("3.  Update a book");
            System.out.println("4.  Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2:
                    addBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
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

    static void viewBooks() {
        if (count == 0) {
            System.out.println("No books found.");
            return;
        }
        String line = "=".repeat(60);
        System.out.println(line);
        System.out.printf("| %-4s| %-8s| %-20s| %-8s| %-10s|%n",
                "No", "ISBN", "Title", "Price", "Author");
        System.out.println(line);
        for (int i = 0; i < count; i++) {
            System.out.printf("| %-4d| %-8d| %-20s| %-8.2f| %-10s|%n",
                    i + 1, isbns[i], titles[i], prices[i], authors[i]);
        }
        System.out.println(line);
    }

    static void addBook(Scanner scanner) {
        System.out.println("==== Add a new book ====");
        System.out.print("ISBN: ");
        isbns[count] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Title: ");
        titles[count] = scanner.nextLine();
        System.out.print("Price: ");
        prices[count] = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Author: ");
        authors[count] = scanner.nextLine();
        count++;
        System.out.println("Book added successfully.");
    }

    static void updateBook(Scanner scanner) {
        System.out.println("==== Update a book ====");
        int targetIsbn;
        int foundIndex = -1;

        while (foundIndex == -1) {
            System.out.print("Input ISBN: ");
            targetIsbn = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < count; i++) {
                if (isbns[i] == targetIsbn) {
                    foundIndex = i;
                    break;
                }
            }

            if (foundIndex == -1) {
                System.out.println("Book is not found. Try again");
            }
        }

        // Prompt for new values
        System.out.println("Please update the following:");
        System.out.print("ISBN: ");
        isbns[foundIndex] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Title: ");
        titles[foundIndex] = scanner.nextLine();
        System.out.print("Price: ");
        prices[foundIndex] = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Author: ");
        authors[foundIndex] = scanner.nextLine();
        System.out.println("Book updated successfully.");
    }
}