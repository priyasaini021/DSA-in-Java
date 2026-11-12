 import java.util.*;

public class RootToleafPath {

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

    public static void printPaths(Node root, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }

        path.add(root.data);

        // Leaf Node
        if (root.left == null && root.right == null) {

            System.out.println(path);
        }

        printPaths(root.left, path);
        printPaths(root.right, path);

        // Backtracking
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        int values[] = {8, 5, 3, 1, 4, 6, 7, 10, 11};

        Node root = null;

        for (int val : values) {
            root = insert(root, val);
        }

        System.out.println("Root to Leaf Paths:");

        printPaths(root, new ArrayList<Integer>());
    }
}

