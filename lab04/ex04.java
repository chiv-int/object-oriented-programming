package lab04;

import java.util.Scanner;

public class ex04 {
    static String[] titles = new String[100];
    static String[] uploaders = new String[100];
    static double[] lengths = new double[100];
    static String[] types = new String[100];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("==== Menu ===");
            System.out.println("1.   Search");
            System.out.println("2.   View all videos");
            System.out.println("3.   Add a new video");
            System.out.println("4.   Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    searchVideo(scanner);
                    break;
                case 2:
                    viewVideos();
                    break;
                case 3:
                    addVideo(scanner);
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

    static void viewVideos() {
        if (count == 0) {
            System.out.println("No videos found.");
            return;
        }
        String line = "=".repeat(65);
        System.out.println(line);
        System.out.printf("| %-4s| %-22s| %-15s| %-8s| %-8s|%n",
                "No", "Title", "Uploader", "Length", "Type");
        System.out.println(line);
        for (int i = 0; i < count; i++) {
            System.out.printf("| %-4d| %-22s| %-15s| %-8.2f| %-8s|%n",
                    i + 1, titles[i], uploaders[i], lengths[i], types[i]);
        }
        System.out.println(line);
    }

    static void addVideo(Scanner scanner) {
        System.out.println("==== Add a new video ====");
        System.out.print("Title: ");
        titles[count] = scanner.nextLine();
        System.out.print("Uploader: ");
        uploaders[count] = scanner.nextLine();
        System.out.print("Length (minutes): ");
        lengths[count] = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Type: ");
        types[count] = scanner.nextLine();
        count++;
        System.out.println("Video added successfully.");
    }

    static void searchVideo(Scanner scanner) {
        System.out.println("==== Video Search ====");
        boolean found = false;

        while (!found) {
            System.out.print("Input title: ");
            String keyword = scanner.nextLine().toLowerCase();

            // Collect matching indices
            int[] matchIndices = new int[100];
            int matchCount = 0;

            for (int i = 0; i < count; i++) {
                if (titles[i].toLowerCase().contains(keyword)) {
                    matchIndices[matchCount++] = i;
                }
            }

            if (matchCount == 0) {
                System.out.println("0 video found. Try again");
            } else {
                System.out.println(matchCount + " videos found:");
                for (int i = 0; i < matchCount; i++) {
                    int idx = matchIndices[i];
                    System.out.println((i + 1) + ". " + titles[idx] + " - " + uploaders[idx]);
                }
                found = true;
            }
        }
    }
}