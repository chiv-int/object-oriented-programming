package lab03;
import java.util.Scanner;
public class ex01 {
    public static void main(String[] arg){ //Quadratic equation
        System.out.println(" Program for calculating rootd of quadratic equation ax^2 + bx + c = 0");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input value of a: ");
        double a = sc.nextDouble();
        System.out.print("Input value of b: ");
        double b = sc.nextDouble();    
        System.out.print("Input value of c: ");
        double c = sc.nextDouble(); 
        double discriminant = b*b - 4*a*c;

        if (discriminant > 0) {
        double X1 = (-b + Math.sqrt(b*b - 4*a*c)) / (2*a);
        double X2 = (-b - Math.sqrt(b*b - 4*a*c)) / (2*a);
        System.out.println("The roots of the equation are: " + X1 + " and " + X2);
        }
        else if (discriminant == 0) {
        double X = -b / (2*a);  
        System.out.println("The root of the equation is: " + X);
        }
        else { 
        System.out.println("The equation roots are complex and cannot be calculated using real numbers.");
        }
        sc.close(); 
    }

}
