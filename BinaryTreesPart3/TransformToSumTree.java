 public class TransformToSumTree {
   static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static int transform(Node root) {

        if (root == null) {
            return 0;
        }

        int leftSum = transform(root.left);
        int rightSum = transform(root.right);

        int oldValue = root.data;

        root.data = leftSum + rightSum;

        return oldValue + leftSum + rightSum;
    }

    public static void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transform(root);

        System.out.print("Sum Tree Preorder: ");
        preorder(root);
    }
}

