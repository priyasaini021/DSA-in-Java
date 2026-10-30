 public class SearchInLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node head;

    public static void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public static int search(int key) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data == key) {
                return index;
            }

            temp = temp.next;
            index++;
        }

        return -1;
    }

    public static void main(String[] args) {
        addLast(10);
        addLast(20);
        addLast(30);
        addLast(40);

        int key = 30;
        int result = search(key);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}

