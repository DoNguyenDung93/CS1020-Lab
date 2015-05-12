// CS1020 (AY2014/5 Semester 2)
// Take-home Lab4 Ex2
// Name: Do Nguyen Dung
// Matric. No.: A0129889A
// Lab group: C04
// This program will stimulate a queue system using VIP and regular type of customers
// It will also calculate how many customers in the line in front of a particular customers

import java.util.*;

public class QueueSimulation {
    //Node head;
    //Node tail;
    //int size;
    LinkedList<Node> queue;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueSimulation newQueue = new QueueSimulation();
        int originalNumOfCustomers = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < originalNumOfCustomers; i++) {
            newQueue.insert(0, sc.nextLine().trim());
        }
        int numOfNewCustomers = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < numOfNewCustomers; j++) {
            String typeStr = sc.next();
            if (typeStr.equals("Regular")) {
                newQueue.insert(0, sc.nextLine().trim());
            } else {
                newQueue.insert(1, sc.nextLine().trim());
            }
        }
        newQueue.printQueue();
        newQueue.printSearchUser(sc.nextLine().trim());
    }

    public QueueSimulation() {
        queue = new LinkedList<Node>();
    }


    /*
    Method Description: this method will insert a customer in the queue depends on the type of the customer
    Post Cond: the VIP is in front of regular customers
    Pre Cond: the type is either 0 (regular) or 1 (VIP)
    */
    public void insert(int type, String data) {
        if (type == 0) {
            queue.addLast(new Node(data, 0));
        } else {
            int firstRegular = 0;
            for (int i = 0; i < queue.size(); i++) {
                int num = queue.get(i).getType();
                if (num == 0) {
                    firstRegular = i;
                    break;
                }
            }
            queue.add(firstRegular, new Node(data, 1));
        }
    }

    /*
    Method Description: this method will print the name of the customers in the queue
    Post Cond: the positions of the customers are correct
    Pre Cond: the queue is not empty
    */
    public void printQueue() {
        System.out.print("Final queue: ");
        for (int i = 0; i < queue.size() - 1; i++) {
            System.out.print(queue.get(i).getData() + ", ");
        }
        System.out.print(queue.get(queue.size() - 1).getData());
        System.out.println();
    }


    /*
    Method Description: this method will tell the user how many customers are in front of a particular customer
    Post Cond: the output is correct
    Pre Cond: the queue is finalized
    */
    public void printSearchUser(String searchUser) {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).getData().equals(searchUser)) {
                System.out.println("There are " + i + (i == 1 ? " customer" : " customers") + " ahead of " + searchUser);
            }
        }
    }

}


class Node {
    private String item; //variable which stores the name of the person in queue
    private int type; //variable to differentiate priority
    private Node prev;
    private Node next;
    //additional attributes here you think you might need


    //default constructor implement any other constructors you deem necessary
    public Node(String item, int type) {
        this(item, type, null, null);
    }

    public Node(String item, int type, Node prev, Node next) {
        this.item = item;
        this.type = type;
        this.prev = prev;
        this.next = next;
    }

    public String getData() {
        return item;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public int getType() {
        return type;
    }

    public void setPrev(Node prevNode) {
        prev = prevNode;
    }

    public void setNext(Node nextNode) {
        next = nextNode;
    }
}

