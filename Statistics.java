// This program computes the mean and standard deviation
// of an array of values.

import java.text.DecimalFormat;
import java.util.Scanner;

public class Statistics {

    public static void main(String[] args) {
        int[] arr = readArray();

        // For checking; remove the following 2 lines before submission
        //System.out.print("Values: ");
        //printArray(arr);

        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        String mean = decimalFormat.format(computeMean(arr));
        String standardDe = decimalFormat.format(computeStdDev(arr));

        System.out.println("Mean = " + mean);
        System.out.println("Standard deviation = " + standardDe);
    }

    // Read a list of values into an array arr
    public static int[] readArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int arraySize = sc.nextInt();
        int[] arr = new int[arraySize];
        System.out.println("Enter " + arraySize + ((arraySize > 1) ? " values: " : " value: "));
        for (int i = 0; i < arraySize; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    // Compute mean of the values in arr
    // Precond: arr.length > 0
    public static double computeMean(int[] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        double mean = (double) sum / arr.length;
        return mean;
    }

    // Compute standard deviation of the values in arr
    // Precond: arr.length > 0
    public static double computeStdDev(int[] arr) {
        double sumVar = 0;
        for (int element : arr) {
            sumVar += Math.pow(element - computeMean(arr), 2);
        }
        double var = sumVar / arr.length;
        double standardDe = Math.sqrt(var);
        return standardDe;
    }

    // Print the array arr on a single line.
    // Note that the last element has a space after it.
    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
} 

