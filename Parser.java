

import java.util.*;
/*
class Tag {
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
*/
/* Parser for the markup language */

public class Parser {

    private Stack<String> openingTag;
    private LinkedList<String> closingTag;
    private Stack<String> singleTag;

    public Parser(Scanner sc) {
        openingTag = new Stack<String>(); // a stack for opening tags
        closingTag = new LinkedList<String>(); // a queue for closing tags
        singleTag = new Stack<String>(); // a stack for single tags
        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            //System.out.println(temp);
            if (temp.contains("<B>") || temp.contains("<P>") || temp.contains("<S>") || temp.contains("<I>")) {
                openingTag.push(temp);
            } else if (temp.contains("</B>") || temp.contains("</P>") || temp.contains("</S>") || temp.contains("</I>")) {
                closingTag.offer(temp);

            } else {
                singleTag.push(temp);
            }

        }
        //System.out.println(openingTag);
        //System.out.println(closingTag);
        //System.out.println(singleTag);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser bc = new Parser(sc);
        boolean result = bc.checkBlankFile();
        if (!result) {
            result = bc.checkSingleTag();
            System.out.println(result);
            if (result) {
                result = bc.checkPairedTag();
            }
            System.out.println(result);
        }
        if (result) {
            System.out.println("No Error");
        } else {
            System.out.println("Error!");
        }
    }

    // this method will check for invalid tag name
    public boolean checkSingleTag() {
        boolean result = false;
        while (!singleTag.empty()) {
            String lastItem = singleTag.pop();
            //System.out.println(lastItem);
            if (lastItem.contains("<TEXT>") || lastItem.contains("<PB>") || lastItem.contains("<LB>")) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    // this method will check for unclosed paired tag name
    public boolean checkPairedTag() {
        boolean result = true;
        while (!openingTag.empty()) {
            if (!openingTag.pop().equals(closingTag.poll().replace("/", ""))) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean checkBlankFile() {
        return (openingTag.empty() && closingTag.isEmpty() && singleTag.empty());
    }

    /*
    public int checkTagType(String name) {
        int result = 0;
        if (name.contains("<B>") || name.contains("<P>") || name.contains("<S>") || name.contains("<I>")) {
            result = 1;
        } else if (name.contains("</B>") || name.contains("</P>") || name.contains("</S>") || name.contains("</I>")) {
            result = 2;
        } else {
            result = 0;
        }
        return result;
    }*/
}
