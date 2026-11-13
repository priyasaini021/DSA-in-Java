 public class LargestBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Info {

        int size;
        long min;
        long max;
        boolean isBST;

        Info(int size, long min, long max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(0, Long.MAX_VALUE,
                    Long.MIN_VALUE, true);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;

        long min = Math.min(root.data,
                Math.min(leftInfo.min, rightInfo.min));

        long max = Math.max(root.data,
                Math.max(leftInfo.max, rightInfo.max));

        if (leftInfo.isBST && rightInfo.isBST &&
                root.data > leftInfo.max &&
                root.data < rightInfo.min) {

            return new Info(size, min, max, true);
        }

        return new Info(
                Math.max(leftInfo.size, rightInfo.size),
                min,
                max,
                false
        );
    }

    public static void main(String[] args) {
        Node root = new Node(50);

        root.left = new Node(30);
        root.right = new Node(60);

        root.left.left = new Node(5);
        root.left.right = new Node(65);

        root.right.left = new Node(55);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);

        Info ans = largestBST(root);

        System.out.println("Size of Largest BST: " + ans.size);
    }
}
