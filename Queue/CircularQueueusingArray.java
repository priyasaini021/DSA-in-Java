 public class CircularQueueusingArray {

    static class Queue {
        static int arr[];
        static int size;
        static int front;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        // Add element
        public static void add(int data) {
            if ((rear + 1) % size == front) {
                System.out.println("Queue is Full");
                return;
            }

            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Remove element
        public static int remove() {
            if (front == -1) {
                System.out.println("Queue is Empty");
                return -1;
            }

            int result = arr[front];

            if (rear == front) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        // Peek element
        public static int peek() {
            if (front == -1) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue(3);

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Removed: " + q.remove());

        q.add(40);

        System.out.println("Front: " + q.peek());
    }
}

