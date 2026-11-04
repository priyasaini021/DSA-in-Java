import java.util.*;

public class QueueUsingDeque {

    static Deque<Integer> dq = new ArrayDeque<>();

    // Add element
    public static void add(int data) {
        dq.addLast(data);
    }

    // Remove element
    public static int remove() {

        if (dq.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return dq.removeFirst();
    }

    // Peek element
    public static int peek() {

        if (dq.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return dq.peekFirst();
    }

    public static void main(String[] args) {

        add(10);
        add(20);
        add(30);

        System.out.println("Queue: " + dq);

        System.out.println("Front: " + peek());

        System.out.println("Removed: " + remove());

        System.out.println("Updated Queue: " + dq);
    }
}

