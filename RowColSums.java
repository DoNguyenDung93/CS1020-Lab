// RowColSums.java
// To compute the row and column sums of a 2D array.

import java.util.*;

public class RowColSums {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows and columns: ");
        int numRow = sc.nextInt();
        int numCol = sc.nextInt();
        int[][] array2D = new int[numRow][numCol];
        System.out.println("Enter values for 2D array:");
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                array2D[i][j] = sc.nextInt();
            }
            //sc.nextLine();
        }

        int[] rowSums = computeRowSums(array2D, numRow, numCol);
        System.out.print("Row sums: ");
        System.out.println(Arrays.toString(rowSums));

        int[] colSums = computeColSums(array2D, numRow, numCol);
        System.out.print("Column sums: ");
        System.out.println(Arrays.toString(colSums));
    }

    public static int[] computeRowSums(int[][] arr, int numRow, int numCol) {
        int[] rowSums = new int[numRow];
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                rowSums[i] += arr[i][j];
            }
        }
        return rowSums;
    }

    public static int[] computeColSums(int[][] arr, int numRow, int numCol) {
        int[] colSums = new int[numCol];
        for (int i = 0; i < numCol; i++) {
            for (int j = 0; j < numRow; j++) {
                colSums[i] += arr[j][i];
            }
        }
        return colSums;
    }
}
