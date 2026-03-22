package lab02;
import java.util.Scanner;
public class ex08 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a value of A: ");
        int A = sc.nextInt();
        System.out.print("Input a value of B: ");
        int B = sc.nextInt();       
        System.out.print("Input a value of C: ");
        int C = sc.nextInt();   
        System.out.print("Input a value of D: ");
        int D = sc.nextInt();     
        System.out.print("Input a value of E: ");
        int E = sc.nextInt();
         int min = A; // assume A is smallest first
        if (B < min) min = B;
        if (C < min) min = C;
        if (D < min) min = D;
        if (E < min) min = E;
        System.out.println("The smallest number among A, B, C, D, and E is: " + min);
        sc.close();
    }
}
