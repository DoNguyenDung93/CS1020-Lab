// CS1020 (AY2014/5 Semester 2)
// Take-home Lab1 Ex2
// Name: Do Nguyen Dung
// Matric. No.: A0129889A
// Lab group: C04
// This program will take the input from the user and will check if there is any palindromes

import java.lang.String;
import java.util.Scanner;

public class Palindromes {

    public static boolean isPalindrome(String text) {
        String newText = text.trim().toLowerCase();
        newText = newText.replaceAll("[^a-zA-Z]", "");
        int length = newText.length();
        for (int i = 0; i < length / 2; i++) {
            if (newText.charAt(i) != newText.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static final int MAX_STRING = 9999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] text = new String[MAX_STRING];
        int numPalindromes = 0;
        int i = 0;

        System.out.print("Enter text: ");
        do {
            text[i] = sc.nextLine();
            if (isPalindrome(text[i])) {
                numPalindromes++;
            }
            System.out.print("Enter text: ");
        } while (sc.hasNextLine());

        System.out.println("Number of palindromes = " + numPalindromes);
    }
}

