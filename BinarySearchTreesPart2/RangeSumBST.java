 public class RangeSumBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static int rangeSum(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.data < low) {
            return rangeSum(root.right, low, high);
        }

        if (root.data > high) {
            return rangeSum(root.left, low, high);
        }

        return root.data
                + rangeSum(root.left, low, high)
                + rangeSum(root.right, low, high);
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

    public static void main(String[] args) {

        int values[] = {8, 5, 3, 1, 4, 6, 10, 11};

        Node root = null;

        for (int val : values) {
            root = insert(root, val);
        }

        int low = 4;
        int high = 10;

        System.out.println("Range Sum: " +
                rangeSum(root, low, high));
    }
}

