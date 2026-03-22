package lab02;

import java.util.Scanner;

public class ex01 {
    public static void main(String[] arg){
        String name;
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Hello, " + name);
        sc.close();
    }   
}
