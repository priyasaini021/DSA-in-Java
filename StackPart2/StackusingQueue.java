import java.util.*;

public class StackusingQueue {

    static Queue<Integer> q = new LinkedList<>();

    // Push operation
    public static void push(int data) {
        q.add(data);

        int size = q.size();

        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    // Pop operation
    public static int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return q.remove();
    }

    // Peek operation
    public static int peek() {
        if (q.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return q.peek();
    }

    public static void main(String[] args) {

        push(10);
        push(20);
        push(30);

        System.out.println("Top element: " + peek());

        System.out.println("Popped: " + pop());
        System.out.println("Popped: " + pop());

        System.out.println("Top element: " + peek());
    }
}