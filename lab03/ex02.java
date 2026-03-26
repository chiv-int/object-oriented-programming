package lab03;
import java.util.Scanner;
public class ex02 {
    public static void main(String[] arg){//N times fo Input
        Scanner sc = new Scanner(System.in);
        System.out.println("How many number to be input?");
        System.out.print("Number of Input:");
        int n = sc.nextInt();

        double sum =0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        int[] numbers = new int[n];
        for(int i=0; i<n; i++){
            System.out.print("Input number "+(i+1)+":");
            numbers[i] = sc.nextInt();

            sum += numbers[i];
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        sc.close();
    }
    
}
