package lab04;
import java.util.ArrayList;
import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<int[]> ids = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();

        int count = 1;
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {
            System.out.println("Student #" + count + ":");
            System.out.print("Id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            ids.add(new int[]{id});
            names.add(name);
            ages.add(age);
            count++;

            System.out.print("\nDo you want to add more (y/n)?: ");
            choice = scanner.nextLine();
            System.out.println();
        }

        // Print table
        String line = "=".repeat(50);
        System.out.println(line);
        System.out.printf("| %-10s| %-10s| %-15s| %-8s|%n", "No", "ID", "Name", "Age");
        System.out.println(line);
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("| %-10d| %-10d| %-15s| %-8d|%n",
                    i + 1, ids.get(i)[0], names.get(i), ages.get(i));
        }
        System.out.println(line);

        scanner.close();
    }
}