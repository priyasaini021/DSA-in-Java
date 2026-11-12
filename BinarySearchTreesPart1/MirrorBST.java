 public class MirrorBST {
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

    public static Node mirror(Node root) {

        if (root == null) {
            return null;
        }

        Node leftMirror = mirror(root.left);
        Node rightMirror = mirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

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

        System.out.print("Original BST: ");
        inorder(root);

        root = mirror(root);

        System.out.print("\nMirror BST: ");
        inorder(root);
    }
}
