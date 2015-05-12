/**
 * Created by Do Nguyen Dung on 4/2/2015.
 */

import java.util.Scanner;

public class LongestSubstring2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String string = sc.next();
        string = string.toLowerCase();

        int startPos = 0;
        int newStartPos = 0;
        int maxSubLength = 0;
        int tempSubLength = 0;

        for (int endPos = startPos + 1; endPos < string.length(); endPos++) {
            for (int checkPos = endPos - 1; checkPos >= startPos; checkPos--) {
                if (string.charAt(checkPos) == string.charAt(endPos)) {
                    //newStartPos = checkPos + 1;
                    tempSubLength = endPos - startPos;
                    startPos = checkPos + 1;
                    break;
                }
            }
            maxSubLength = Math.max(tempSubLength, maxSubLength);
        }

        if (maxSubLength == 0) {
            maxSubLength = string.length();
        }

        System.out.println("The longest substring has the length of: " + maxSubLength);
    }
}
