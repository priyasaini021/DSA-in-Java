 import java.util.*;

public class MinStack {

    static Stack<Integer> s = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    // Push operation
    public static void push(int data) {
        s.push(data);

        if (minStack.isEmpty() || data <= minStack.peek()) {
            minStack.push(data);
        }
    }

    // Pop operation
    public static int pop() {
        if (s.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        int top = s.pop();

        if (top == minStack.peek()) {
            minStack.pop();
        }

        return top;
    }

    // Peek operation
    public static int peek() {
        if (s.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return s.peek();
    }

    // Get Minimum Element
    public static int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return minStack.peek();
    }

    public static void main(String[] args) {

        push(5);
        push(3);
        push(7);
        push(2);

        System.out.println("Top Element: " + peek());
        System.out.println("Minimum Element: " + getMin());

        System.out.println("Popped: " + pop());

        System.out.println("Minimum Element: " + getMin());
    }
}
