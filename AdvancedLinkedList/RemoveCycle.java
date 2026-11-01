 public class RemoveCycle {
 static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void removeCycle(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        boolean cycle = false;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (!cycle) {
            return;
        }

        // Find cycle starting point
        slow = head;

        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Remove cycle
        fast.next = null;
    }

    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Create cycle
        head.next.next.next.next = head.next;

        removeCycle(head);

        System.out.println("After Removing Cycle:");
        printList(head);
    }
}
    