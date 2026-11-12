
public class PrintInRange {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {

        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        }
        else if (val > root.data) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {

        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {

            printInRange(root.left, k1, k2);

            System.out.print(root.data + " ");

            printInRange(root.right, k1, k2);
        }

        else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        }

        else {
            printInRange(root.left, k1, k2);
        }
    }

    public static void main(String[] args) {

        int values[] = {8, 5, 3, 1, 4, 6, 7, 10, 11};

        Node root = null;

        for (int val : values) {
            root = insert(root, val);
        }

        int k1 = 4;
        int k2 = 10;

        System.out.print("Values in Range: ");
        printInRange(root, k1, k2);
    }
}

