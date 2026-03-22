package lab02;
import java.util.Scanner;
public class ex02 {
    public static void main(String[] arg){
        double riels;
        double conversionRate;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Program for converting money in Riels to Dollars.");
        System.out.println("Please input conversion rate of 1 dollar in Riels: ");
        conversionRate = sc.nextDouble();
        System.out.println("Please input amount of money in Riels: ");
        riels = sc.nextDouble();
        double dollars = riels / conversionRate;
        System.out.println(riels + "RIELS = " + dollars + " USD");
        sc.close();

    }
    
}
