package lab02;
import java.util.Scanner;

public class ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Print menu
            System.out.println("=== Math Menu ===");
            System.out.println("1. Addition (+)");
            System.out.println("2. Substraction (-)");
            System.out.println("3. Multiplication (x)");
            System.out.println("4. Division (/)");
            System.out.println("5. Quit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();

            // if invalid option, ask again
            if (choice < 1 || choice > 5) {
                System.out.println("Please choose an option again.");
                continue; // jump back to top of while loop
            }

            // quit
            if (choice == 5) {
                System.out.println("Goodbye!");
                running = false;
                continue;
            }

            // get A and B
            System.out.print("Please input value A: ");
            double a = scanner.nextDouble();
            System.out.print("Please input value B: ");
            double b = scanner.nextDouble();

            // perform calculation
            double result = 0;
            String operation = "";

            if (choice == 1) {
                result = a + b;
                operation = "A + B";
            } else if (choice == 2) {
                result = a - b;
                operation = "A - B";
            } else if (choice == 3) {
                result = a * b;
                operation = "A x B";
            } else if (choice == 4) {
                result = a / b;
                operation = "A / B";
            }

            System.out.println("Answer of " + operation + " = " + result);

            // ask to continue or go back to menu
            scanner.nextLine(); // clear leftover newline
            System.out.print("Do you want to continue? If no go to Menu. Input your answer (y/n): ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("n")) {
                // go back to menu (loop continues automatically)
            }
            // if y, loop continues and shows menu again
        }

        scanner.close();
    }
}
