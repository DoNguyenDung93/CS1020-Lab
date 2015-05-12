// CS1020 (AY2014/5 Semester 2)
// Take-home Lab2 Ex1
// Name: Do Nguyen Dung
// Matric. No.: A0129889A
// Lab group: C04
// This program will create a KWIC class for the program KWICIndexSystem to run

import java.util.*;

class KWIC {
    private ArrayList<String> ignoreWordList;
    private ArrayList<String> titleList;
    //private ArrayList<String> finalResult;

    public KWIC(ArrayList<String> ignoreWordList, ArrayList<String> titleList) {
        setIgnoreWordList(ignoreWordList);
        setTitleList(titleList);
    }

    /* Pre-condition: input is valid */
    /* Post-condition: titleList is not empty */
    /* Description: Add a new title to titleList. */
    public void addWordToTitleList(String word) {
        titleList.add(word);
    }

    public void setIgnoreWordList(ArrayList<String> ignoreWordList) {
        this.ignoreWordList = ignoreWordList;
    }

    /* Pre-condition: input is valid */
    /* Post-condition: ignoreWordList is not empty */
    /* Description: Add a new title to ignoreWordList. */
    public void addWordToIgnoreWordList(String word) {
        ignoreWordList.add(word);
    }

    public void setTitleList(ArrayList<String> titleList) {
        this.titleList = titleList;
    }

    /* Description: This method is to find the final result. */
    public ArrayList<String> findKWICIndex() {
        ArrayList<String> finalResult = new ArrayList<String>();
        circularShift(finalResult);
        for (int i = 0; i < finalResult.size(); i++) {
            finalResult.set(i, capitalizeKeyword(finalResult.get(i)));
        }
        orderInAlphabetical(finalResult);
        return finalResult;
    }

    /* Pre-condition: all input are correct */
    /* Post-condition: the result is valid */
    /* Description: To print out the final result. */
    public void printOutResult(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            //String newList = list.get(i).replaceAll(",, ", " ").replaceAll("\\[|\\]", "");
            System.out.println(list.get(i).replaceAll(",", "").replaceAll("\\[|\\]", ""));
        }
        //System.out.println("Ignore " + ignoreWordList);
    }

    /* Pre-condition: all input are correct */
    /* Post-condition: all output is stored in the list */
    /* Description: Receive a list of titles and wordToIgnore, circular shift all the titles and store them. */
    /* Note that wordToIgnore cannot be in the beginning of a title. */
    private ArrayList<String> circularShift(ArrayList<String> list) {
        for (int i = 0; i < titleList.size(); i++) {
            //System.out.println("a " + this.titleList.get(i));
            ArrayList<String> newTitle = new ArrayList<String>(Arrays.asList(this.titleList.get(i).split(" ")));
            //System.out.println("New title is " + newTitle);
            for (int j = 0; j < newTitle.size(); j++) {
                newTitle.add(newTitle.remove(0));
                if (ignoreWordList.contains(newTitle.get(0))) {
                    continue;
                }
                list.add(newTitle.toString());
            }
        }
        return list;
    }

    /* Pre-condition:  */
    /* Post-condition:  */
    /* Description: To sort a list in alphabetical order. */
    private ArrayList<String> orderInAlphabetical(ArrayList<String> list) {
        Collections.sort(list);
        return list;
    }

    /* Pre-condition:  */
    /* Post-condition:  */
    /* Description: To capitalize every first character of keywords. */
    private String capitalizeKeyword(String title) {
        title = title.replaceAll(",", "").replaceAll("\\[|\\]", "");
        //System.out.println("Title is " + title);
        ArrayList<String> newTitle = new ArrayList<String>(Arrays.asList(title.split(" ")));
        //System.out.println("New title is " + newTitle);
        for (int i = 0; i < newTitle.size(); i++) {
            if (ignoreWordList.contains(newTitle.get(i))) {
                continue;
            }
            newTitle.set(i, newTitle.get(i).substring(0, 1).toUpperCase() + newTitle.get(i).substring(1));
        }
        return newTitle.toString();
    }
}
