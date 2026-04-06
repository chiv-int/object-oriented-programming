package lab5;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class MyDate {

    // Method 1: Get current date and time
    public void getCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date now = new Date();
        System.out.println("Current datetime is: " + format.format(now));
    }

    // Method 2: Calculate days between two dates
    public void calculateDaysBtwDates() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        try {
            System.out.print("First date (dd/mm/yyyy): ");
            Date date1 = format.parse(sc.nextLine().trim());

            System.out.print("Second date (dd/mm/yyyy): ");
            Date date2 = format.parse(sc.nextLine().trim());

            long ms1 = date1.getTime();
            long ms2 = date2.getTime();
            long diffMs = Math.abs(ms2 - ms1);
            long diffDays = diffMs / (1000 * 60 * 60 * 24);

            System.out.println("Difference between two dates is: " + diffDays + " days");

        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/mm/yyyy.");
        }
    }

    // Method 3: Find the day of the week
    public void findDay() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        try {
            System.out.print("Input a date: ");
            Date date = format.parse(sc.nextLine().trim());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            String[] days = {"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            System.out.println("The day is: " + days[dayOfWeek]);

        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/mm/yyyy.");
        }
    }
}

public class ex01{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyDate myDate = new MyDate();
        int choice;

        do {
            System.out.println("\n==== Menu ===");
            System.out.println("1.  Current date and time");
            System.out.println("2.  Calculate days btw two dates");
            System.out.println("3.  Find the day of the week");
            System.out.println("4.  Quit");
            System.out.print("Choose an opt: ");

            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    myDate.getCurrentDate();
                    break;
                case 2:
                    myDate.calculateDaysBtwDates();
                    break;
                case 3:
                    myDate.findDay();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-4.");
            }

        } while (choice != 4);

        sc.close();
    }
}