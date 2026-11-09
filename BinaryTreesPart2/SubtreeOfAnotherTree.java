  public class SubtreeOfAnotherTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isIdentical(Node root, Node subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.data != subRoot.data) {
            return false;
        }

        return isIdentical(root.left, subRoot.left) &&
               isIdentical(root.right, subRoot.right);
    }

    public static boolean isSubtree(Node root, Node subRoot) {

        if (root == null) {
            return false;
        }

        if (isIdentical(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        if (isSubtree(root, subRoot)) {
            System.out.println("Subtree exists");
        } else {
            System.out.println("Subtree does not exist");
        }
    }
}
