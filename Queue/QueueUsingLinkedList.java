 public class QueueUsingLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node front = null;
        static Node rear = null;

        // Add element
        public static void add(int data) {
            Node newNode = new Node(data);

            if (rear == null) {
                front = rear = newNode;
                return;
            }

            rear.next = newNode;
            rear = newNode;
        }

        // Remove element
        public static int remove() {
            if (front == null) {
                System.out.println("Queue is Empty");
                return -1;
            }

            int result = front.data;
            front = front.next;

            if (front == null) {
                rear = null;
            }

            return result;
        }

        // Peek element
        public static int peek() {
            if (front == null) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return front.data;
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Front: " + q.peek());
        System.out.println("Removed: " + q.remove());
        System.out.println("Front: " + q.peek());
    }
}

