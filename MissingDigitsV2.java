// MissingDigitsV2.java
// To find digits that do not appear in user's input number.
// This version uses the Vector class.

import java.util.*;

public class MissingDigitsV2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = sc.nextInt();
        Vector result = findMissingDigits(input);
        System.out.print("Missing digits in " + input + ": ");
        printArray(result);
    }

    public static Vector findMissingDigits(int input) {
        String[] digitsInt = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Vector<String> digits = new Vector<String>(Arrays.asList(digitsInt));
        String temp = Integer.toString(input);
        String[] tempDigits = temp.split("");
        Vector<String> tempInt = new Vector<String>(Arrays.asList(tempDigits));
        for (int a = 0; a < tempInt.size(); a++) {
            for (int b = 0; b < digits.size(); b++) {
                if (digits.get(b).equals(tempInt.get(a))) {
                    digits.set(b, "-1");
                    break;
                }
            }
        }
        return digits;
    }

    public static void printArray(Vector result) {
        for (int i = 0; i < result.size(); i++) {
            if (!result.get(i).equals("-1")) {
                System.out.print(result.get(i) + " ");
            }
        }
    }
}

