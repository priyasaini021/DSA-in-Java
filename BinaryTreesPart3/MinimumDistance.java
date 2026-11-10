 public class MinimumDistance {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node lca(Node root, int n1, int n2) {

        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static int distance(Node root, int n) {

        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int left = distance(root.left, n);

        if (left != -1) {
            return left + 1;
        }

        int right = distance(root.right, n);

        if (right != -1) {
            return right + 1;
        }

        return -1;
    }

    public static int minDistance(Node root, int n1, int n2) {

        Node ancestor = lca(root, n1, n2);

        if (ancestor == null) {
            return -1;
        }

        int d1 = distance(ancestor, n1);
        int d2 = distance(ancestor, n2);

        if (d1 == -1 || d2 == -1) {
            return -1;
        }

        return d1 + d2;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4;
        int n2 = 6;

        System.out.println("Minimum Distance: " +
                minDistance(root, n1, n2));
    }
}

