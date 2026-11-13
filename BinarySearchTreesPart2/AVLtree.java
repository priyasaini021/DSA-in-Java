 public class AVLtree {
    static class Node {

        int data;
        Node left, right;
        int height;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return root.height;
    }

    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    // Right Rotation
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(
                height(y.left),
                height(y.right)) + 1;

        x.height = Math.max(
                height(x.left),
                height(x.right)) + 1;

        return x;
    }

    // Left Rotation
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(
                height(x.left),
                height(x.right)) + 1;

        y.height = Math.max(
                height(y.left),
                height(y.right)) + 1;

        return y;
    }

    // Insert Node
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
        else {
            return root;
        }

        root.height = 1 + Math.max(
                height(root.left),
                height(root.right));

        int balance = getBalance(root);

        // LL Case
        if (balance > 1 && val < root.left.data) {
            return rightRotate(root);
        }

        // RR Case
        if (balance < -1 && val > root.right.data) {
            return leftRotate(root);
        }

        // LR Case
        if (balance > 1 && val > root.left.data) {

            root.left = leftRotate(root.left);

            return rightRotate(root);
        }

        // RL Case
        if (balance < -1 && val < root.right.data) {

            root.right = rightRotate(root.right);

            return leftRotate(root);
        }

        return root;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;

        int values[] = {10, 20, 30, 40, 50, 25};

        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("Preorder Traversal: ");
        preorder(root);

        System.out.print("\nInorder Traversal: ");
        inorder(root);

        System.out.println("\nHeight of AVL Tree: " + height(root));
    }
}
