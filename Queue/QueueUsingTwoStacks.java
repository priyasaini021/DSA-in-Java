5import java.util.*;

public class QueueUsingTwoStacks {

    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    // Add element
    public static void add(int data) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(data);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Remove element
    public static int remove() {
        if (s1.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return s1.pop();
    }

    // Peek element
    public static int peek() {
        if (s1.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return s1.peek();
    }

    public static void main(String[] args) {

        add(10);
        add(20);
        add(30);

        System.out.println("Front: " + peek());

        System.out.println("Removed: " + remove());

        System.out.println("Front: " + peek());
    }
}

