public class ValidateBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isValidBST(Node root,
                                     long min,
                                     long max) {

        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.data) &&
               isValidBST(root.right, root.data, max);
    }

    public static void main(String[] args) {

        Node root = new Node(8);

        root.left = new Node(5);
        root.right = new Node(10);

        root.left.left = new Node(3);
        root.left.right = new Node(6);

        root.right.right = new Node(11);

        if (isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            System.out.println("Valid Binary Search Tree");
        } else {
            System.out.println("Invalid Binary Search Tree");
        }
    }
}

