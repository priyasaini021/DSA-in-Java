 public class KthAncestor {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static int kthAncestor(Node root, int n, int k) {

        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int maxDist = Math.max(leftDist, rightDist);

        if (maxDist + 1 == k) {
            System.out.println("Kth Ancestor: " + root.data);
        }

        return maxDist + 1;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n = 5;
        int k = 2;

        int ans = kthAncestor(root, n, k);

        if (ans == -1 || ans < k) {
            System.out.println("Kth Ancestor does not exist");
        }
    }
}

