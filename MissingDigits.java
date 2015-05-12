// MissingDigits.java
// To find digits that do not appear in user's input number.

import java.util.*;

public class MissingDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = sc.nextInt();
        int[] result = findMissingDigits(input);
        System.out.print("Missing digits in " + input + ": ");
        printArray(result);
    }

    public static int[] findMissingDigits(int input) {
        int[] digit = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String temp = Integer.toString(input);
        int[] inputDigits = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            inputDigits[i] = temp.charAt(i) - '0';
        }
        //printArray(inputDigits);
        for (int a = 0; a < inputDigits.length; a++) {
            for (int b = 0; b < digit.length; b++) {
                if (digit[b] == inputDigits[a]) {
                    digit[b] = -1;
                    break;
                }
            }
        }
        return digit;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                System.out.print(String.valueOf(arr[i]) + " ");
            }
        }
    }
}

