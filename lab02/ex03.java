package lab02;

import java.util.Scanner;

public class ex03 {
        public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ask questions
        System.out.println("=== Covid-19 Screen Health ===");

        System.out.print("Q1. Feeling feverish and/or having chills? ");
        String q1 = input.nextLine();

        System.out.print("Q2. Has there been any use of fever reducing medication within the last 24 hours not due to another health condition? ");
        String q2 = input.nextLine();

        System.out.print("Q3. A new cough that is not due to another health condition? ");
        String q3 = input.nextLine();

        System.out.print("Q4. New chills that are not due to another health condition? ");
        String q4 = input.nextLine();

        System.out.print("Q5. A new sore throat that is not due to another health condition? ");
        String q5 = input.nextLine();

        System.out.print("Q6. A new loss of taste or smell? ");
        String q6 = input.nextLine();

        System.out.print("Q7. Have you had a positive test for COVID-19 disease within the past 10 days? ");
        String q7 = input.nextLine();

        System.out.print("Q8. In the past 14 days, have you had close contact with someone with suspected or confirmed COVID-19? ");
        String q8 = input.nextLine();

        // Display results
        // Header
        System.out.println("==========================================");
        System.out.printf("| %-20s | %-15s |\n", "Questions", "Answers");
        System.out.println("==========================================");

        // Rows (Repeat this pattern for Q1 through Q8)
        System.out.printf("| %-20s | %-15s |\n", "Q1", q1);
        System.out.println("|----------------------|-----------------|");

        System.out.printf("| %-20s | %-15s |\n", "Q2", q2);
        System.out.println("|----------------------|-----------------|");

        System.out.printf("| %-20s | %-15s |\n", "Q3", q3);
        System.out.println("|----------------------|-----------------|");

        System.out.printf("| %-20s | %-15s |\n", "Q4", q4);
        System.out.println("|----------------------|-----------------|");

        System.out.printf("| %-20s | %-15s |\n", "Q5", q5);
        System.out.println("|----------------------|-----------------|");

        System.out.printf("| %-20s | %-15s |\n", "Q6", q6);
        System.out.println("|----------------------|-----------------|");

        System.out.printf("| %-20s | %-15s |\n", "Q7", q7);
        System.out.println("|----------------------|-----------------|");

        System.out.printf("| %-20s | %-15s |\n", "Q8", q8);
        System.out.println("|----------------------|-----------------|");

        input.close();
    }
}