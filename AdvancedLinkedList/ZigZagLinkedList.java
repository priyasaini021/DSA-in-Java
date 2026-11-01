 public class ZigZagLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node head;

    // Find middle
    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Reverse second half
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // ZigZag rearrangement
    public static void zigZag() {
        if (head == null || head.next == null) {
            return;
        }

        Node mid = getMid(head);

        Node secondHalf = reverse(mid.next);
        mid.next = null;

        Node first = head;
        Node second = secondHalf;

        while (second != null) {
            Node nextFirst = first.next;
            Node nextSecond = second.next;

            first.next = second;
            second.next = nextFirst;

            first = nextFirst;

            if (first != null) {
                second = nextSecond;
            }
        }
    }

    public static void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Original List:");
        printList();

        zigZag();

        System.out.println("ZigZag List:");
        printList();
    }
}

