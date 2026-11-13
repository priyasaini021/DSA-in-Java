public class SortedArrayBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node createBST(int arr[], int si, int ei) {
        if (si > ei) {
            return null;
        }

        int mid = si + (ei - si) / 2;

        Node root = new Node(arr[mid]);

        root.left = createBST(arr, si, mid - 1);
        root.right = createBST(arr, mid + 1, ei);

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
       int arr[] = {1, 2, 3, 4, 5, 6, 7};

        Node root = createBST(arr, 0, arr.length - 1);

        System.out.print("Preorder Traversal: ");
        preorder(root);

        System.out.print("\nInorder Traversal: ");
        inorder(root);
    }
}
