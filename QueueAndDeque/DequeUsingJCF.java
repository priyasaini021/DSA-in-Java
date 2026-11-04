  import java.util.*;

public class DequeUsingJCF {

    public static void main(String[] args) {

        Deque<Integer> dq = new ArrayDeque<>();

        // Add elements
        dq.addFirst(10);
        dq.addLast(20);
        dq.addFirst(5);
        dq.addLast(30);

        System.out.println("Deque: " + dq);

        // Get first and last elements
        System.out.println("First Element: " + dq.getFirst());
        System.out.println("Last Element: " + dq.getLast());

        // Remove elements
        dq.removeFirst();
        dq.removeLast();

        System.out.println("Updated Deque: " + dq);

        System.out.println("Size: " + dq.size());
    }
}

