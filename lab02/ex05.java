package lab02;
import java.util.Scanner;
public class ex05 {
    public static void main (String[] arges){
        System.out.println("Program doe calculating equation 1/x = 1/y +1/z to find the value of x");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input value of y: ");
        double y = sc.nextDouble();
        System.out.print("Please input value of z: ");
        double z = sc.nextDouble();
        System.out.println("Result x= " + 1/(1/y + 1/z));
        sc.close();
    }
}
