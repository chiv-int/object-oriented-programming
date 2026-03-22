package lab02;
import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        int totalSeconds;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of seconds: ");
        totalSeconds = scanner.nextInt();
        
        int S = totalSeconds % 60;
        int M = (totalSeconds / 60) % 60;
        int H = totalSeconds / 3600;   
        
        System.out.println("Time corresponding to " + totalSeconds + " seconds is: " + H + ":" + M + ":" + S );
        scanner.close();
    }
}