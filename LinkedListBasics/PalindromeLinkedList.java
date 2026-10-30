 public class PalindromeLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
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

    public static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

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

    public static boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle node
        Node middle = findMiddle(head);

        // Reverse the second half
        Node secondHalf = reverse(middle);

        Node firstHalf = head;
        Node second = secondHalf;

        boolean palindrome = true;

        // Compare both halves
        while (second != null) {
            if (firstHalf.data != second.data) {
                palindrome = false;
                break;
            }

            firstHalf = firstHalf.next;
            second = second.next;
        }

        // Restore the original list
        reverse(secondHalf);

        return palindrome;
    }

    public static void main(String[] args) {
        addLast(1);
        addLast(2);
        addLast(2);
        addLast(1);

        if (isPalindrome()) {
            System.out.println("Linked List is a Palindrome");
        } else {
            System.out.println("Linked List is not a Palindrome");
        }
    }
}
