package lab03;
import java.util.Scanner;
public class ex03 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
        sc.close();
    }

    static void mainMenu() {
        int choice;
        do {
            System.out.println("Phone Setting:");
            System.out.println("1. General          >");
            System.out.println("2. Wi-Fi            >");
            System.out.println("3. Bluetooth        >");
            System.out.println("4. Mobile Data      >");
            System.out.println("5. Hotspot          >");
            System.out.println("6. Notification     >");
            System.out.println("0. Quit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: generalMenu(); break;
                case 2: wifiMenu();    break;
                case 3: notAvailable("Bluetooth");   break;
                case 4: notAvailable("Mobile Data");  break;
                case 5: notAvailable("Hotspot");      break;
                case 6: notAvailable("Notification"); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void generalMenu() {
        int choice;
        do {
            System.out.println("\nGeneral:");
            System.out.println("1. About            >");
            System.out.println("2. Software update  >");
            System.out.println("3. Storage          >");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: generalAbout();          break;
                case 2: generalSoftwareUpdate(); break;
                case 3: notAvailable("General > Storage"); break;
                case 0: break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void generalAbout() {
        int choice;
        do {
            System.out.println("\nGeneral > About:");
            System.out.println("Name        iPhone");
            System.out.println("Model       IXs");
            System.out.println("Version     18.5");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            choice = sc.nextInt();
        } while (choice != 0);
    }
    static void generalSoftwareUpdate() {
        int choice;
        do {
            System.out.println("\nGeneral > Software Update:");
            System.out.println("====================");
            System.out.println("Software is up to date");
            System.out.println("====================");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            choice = sc.nextInt();
        } while (choice != 0);
    }

    static void wifiMenu() {
        int choice;
        do {
            System.out.println("\nWi-Fi:");
            System.out.println("Status          On");
            System.out.println("Network         I-Coffee");
            System.out.println("1. Other networks   >");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: wifiOtherNetworks(); break;
                case 0: break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void wifiOtherNetworks() {
        int choice;
        do {
            System.out.println("\nWi-Fi > Other networks:");
            System.out.println("Bayon coffee        *****");
            System.out.println("Angkor coffee       **");
            System.out.println("Brown coffee        ****");
            System.out.println("Koi                 *");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            choice = sc.nextInt();
        } while (choice != 0);
    }

    static void notAvailable(String title) {
        int choice;
        do {
            System.out.println("\n" + title + ":");
            System.out.println("============================");
            System.out.println("The Feature is not available");
            System.out.println("============================");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            choice = sc.nextInt();
        } while (choice != 0);
    }
}