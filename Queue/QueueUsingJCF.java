 import java.util.*;

public class QueueUsingJCF {

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        // Add elements
        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Queue: " + q);

        // Peek element
        System.out.println("Front: " + q.peek());

        // Remove element
        System.out.println("Removed: " + q.remove());

        // Updated Queue
        System.out.println("Queue: " + q);

        System.out.println("Size: " + q.size());
    }
}

