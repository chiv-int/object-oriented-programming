package lab02;
import java.util.Scanner;
public class ex07 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a sentence: ");
        String sentence = sc.nextLine();
        
        int vowels = 0, consonants = 0, spaces = 0;
        String vowelList = "AEIOUaeiou";

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            
            if (c == ' ') {
                spaces++;
            } else if (Character.isLetter(c)) {
                if (vowelList.indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Count of vowel is: " + vowels);
        System.out.println("Count of consonant is: " + consonants);
        System.out.println("Count of space is: " + spaces);
        sc.close();
    }
}
