// This program processes a list of "add" and "query" operations
// on a queue:
//    Add <a list of integers>: to enqueue integers into queue
//    Query <a list of integers>: to check if integers are present
//                                in queue by dequeueing elements

import java.util.*;

public class QueueExercise {
    public static void main(String[] args) throws NoSuchElementException {

        QueueLL<Integer> queue = new QueueLL<Integer>();
        Scanner sc = new Scanner(System.in);
        String op;

        while (sc.hasNext()) {
            op = sc.next();

            if (op.equals("Add")) {
                while (sc.hasNextInt()) {
                    queue.offer(sc.nextInt());
                }
                System.out.println("Items added: " + queue);
            } else if (op.equals("Query")) {
                while (sc.hasNextInt()) {
                    int temp = sc.nextInt();
                    int met = 0;
                    while (met != 1) {
                        if (queue.isEmpty()) {
                            break;
                        }
                        if (temp == queue.poll()) {
                            met = 1;
                        }
                    }
                }
                if (!queue.isEmpty()) {
                    System.out.println("Query met: " + queue);
                } else {
                    System.out.println("Query not met: " + queue);
                }
            }
        }
    }

    // You may write additional method(s) to make your program more modular

}

