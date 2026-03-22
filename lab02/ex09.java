package lab02;
import java.util.Scanner;
public class ex09 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int index = 0;
        int max = Integer.MIN_VALUE; // start with the smallest possible number
        String choice = "y";

        while (choice.equals("y")) {
            System.out.print("Input value in Array at index " + index + ": ");
            int value = sc.nextInt();

            if (value > max) {
                max = value; // update max if new value is bigger
            }

            index++;
            sc.nextLine(); // clear the leftover newline
            System.out.print("Do you want to add more (y/n)?: ");
            choice = sc.nextLine();
        }

        System.out.println("The biggest number among in Array is: " + max);
        sc.close();
    }
    
}
