
public class SearchInBST {

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

    public static boolean search(Node root, int key) {

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    public static void main(String[] args) {

        int values[] = {8, 5, 3, 1, 4, 6, 7, 10, 11};

        Node root = null;

        for (int val : values) {
            root = insert(root, val);
        }

        int key = 6;

        if (search(root, key)) {
            System.out.println(key + " Found in BST");
        } else {
            System.out.println(key + " Not Found in BST");
        }
    }
}

