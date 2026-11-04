 import java.util.*;

public class InterleaveQueue {

    public static void interleave(Queue<Integer> q) {

        if (q.size() % 2 != 0) {
            System.out.println("Queue size must be even");
            return;
        }

        int size = q.size();
        Queue<Integer> firstHalf = new LinkedList<>();

        // Store first half elements
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        // Interleave both halves
        while (!firstHalf.isEmpty()) {

            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        System.out.println("Original Queue: " + q);

        interleave(q);

        System.out.println("Interleaved Queue: " + q);
    }
}

