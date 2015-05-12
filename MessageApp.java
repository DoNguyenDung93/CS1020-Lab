/*
 * CS1020 (AY2013/4 Sem2)
 * Sit-in Lab 3 #A
 * Author    :
 * Matric no.:
 * Lab group :
 * Description of program:
 */

import java.util.*;

/* Client class to simulate the messaging application */
public class MessageApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numUser = sc.nextInt();
        User[] allUsers = new User[numUser];
        sc.nextLine();
        for (int i = 0; i < numUser; i++) {
            String name = sc.nextLine();
            User newMan = new User();
            newMan.addMessage(name);
            allUsers[i] = newMan;
        }

        int numOp = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numOp; i++) {
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            sendMess(allUsers, arr[1], arr[2], arr[3]);
            System.out.println(line);
            for (int a = 0; a < allUsers.length; a++) {
                //System.out.println(allUsers[a].size());
                if (allUsers[a].size() > 1) {
                    System.out.println(allUsers[a]);
                    //System.out.println(Arrays.toString(allUsers[a].toArray()));
                } else {
                    System.out.println(allUsers[a].getFirst() + "@");
                    //System.out.println(Arrays.toString(allUsers[a].toArray()));
                }
            }
            //sc.nextLine();
        }

    }

    public static void sendMess(User[] arr, String item1, String item2, String mess) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getFirst().equals(item1))
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j].getFirst().equals(item2)) {
                        arr[i].addMessage(mess);
                        //System.out.println(arr[i]);
                        arr[j].addMessage(mess);
                    }
                }
        }
    }


}


/* Service class representing a user */
class User {
    LinkedList<String> user;

    public User() {
        user = new LinkedList<String>();
    }

    public void addMessage(String item) {
        if (user.size() <= 11) {
            user.addLast(item);
        } else {
            user.removeFirst();
            user.addLast(item);
        }
    }

    public String getFirst() {
        return user.getFirst();
    }


    //public void addFirst(String item) {
    //user.addFirst(item);
// }
    public int size() {
        return user.size();
    }

    //public String[] toArray() {
    //return user.toArray();
    //}


    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i< user.size(); i++) {
            String temp = user.get(i);
            result = result + temp + " ";
        }
        return result;
    }

}
