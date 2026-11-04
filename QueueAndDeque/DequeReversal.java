 import java.util.*;

public class DequeReversal {

    public static void reverseDeque(Deque<Integer> dq) {

        Stack<Integer> s = new Stack<>();

        // Push deque elements into stack
        while (!dq.isEmpty()) {
            s.push(dq.removeFirst());
        }

        // Add elements back from stack
        while (!s.isEmpty()) {
            dq.addLast(s.pop());
        }
    }

    public static void main(String[] args) {

        Deque<Integer> dq = new ArrayDeque<>();

        dq.addLast(10);
        dq.addLast(20);
        dq.addLast(30);
        dq.addLast(40);
        dq.addLast(50);

        System.out.println("Original Deque: " + dq);

        reverseDeque(dq);

        System.out.println("Reversed Deque: " + dq);
    }
}

