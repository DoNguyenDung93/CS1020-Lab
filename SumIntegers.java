// This program computes sum of positive integers up to n
// Add import statement below

import java.lang.*;
import java.util.*;

// Java naming convention:
// Class names should be in UpperCamelCase, with the first 
// letter of every word capitalised.
public class SumIntegers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        int sum = 0;

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        while (count <= n) {
            sum += count;
            count++;
        }

        System.out.println("Sum = " + sum);

    }

}
