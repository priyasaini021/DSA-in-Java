
public class DeleteNode {

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

    public static Node findInorderSuccessor(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static Node delete(Node root, int val) {

        if (root == null) {
            return null;
        }

        if (val < root.data) {
            root.left = delete(root.left, val);
        }

        else if (val > root.data) {
            root.right = delete(root.right, val);
        }

        else {

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                return root.right;
            }

            else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            Node IS = findInorderSuccessor(root.right);

            root.data = IS.data;

            root.right = delete(root.right, IS.data);
        }

        return root;
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

        int values[] = {8, 5, 3, 1, 4, 6, 7, 10, 11};

        Node root = null;

        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("Before Deletion: ");
        inorder(root);

        root = delete(root, 5);

        System.out.print("\nAfter Deletion: ");
        inorder(root);
    }
}

