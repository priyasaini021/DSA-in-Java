
public class QueueUsingArray {

    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // Add element
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is Full");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        // Remove element
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            int front = arr[0];

            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }

            rear--;
            return front;
        }

        // Peek element
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return arr[0];
        }

        public static boolean isEmpty() {
            return rear == -1;
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue(5);

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Front: " + q.peek());
        System.out.println("Removed: " + q.remove());
        System.out.println("Front: " + q.peek());
    }
}
