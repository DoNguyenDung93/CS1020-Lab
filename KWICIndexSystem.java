// CS1020 (AY2014/5 Semester 2)
// Take-home Lab2 Ex1
// Name: Do Nguyen Dung
// Matric. No.: A0129889A
// Lab group: C04
// This program will take in some movie titles and a list of "words to ignore"
// and it will produce a list of strings which is the rearranged movie titles
// and do not start with one of the "words to ignore".

import java.util.*;

public class KWICIndexSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ignoreWordList = new ArrayList<String>();
        ArrayList<String> titleList = new ArrayList<String>();
        KWIC input = new KWIC(ignoreWordList, titleList);
        int numOfIgnoreWords = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numOfIgnoreWords; i++) {
            input.addWordToIgnoreWordList(sc.nextLine());
        }
        int numTitleList = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < numTitleList; j++) {
            input.addWordToTitleList(sc.nextLine());
        }
        //System.out.println(input);
        ArrayList<String> output = input.findKWICIndex();
        input.printOutResult(output);

    }
}
