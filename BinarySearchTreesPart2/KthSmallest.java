
    public class KthSmallest {
    
        static class Node {
            int data;
            Node left, right;
    
            Node(int data) {
                this.data = data;
            }
        }
    
        static int count = 0;
        static int ans = -1;
    
        public static void kthSmallest(Node root, int k) {
            if (root == null) {
                return;
            }
    
            kthSmallest(root.left, k);
    
            count++;
    
            if (count == k) {
                ans = root.data;
                return;
            }
    
            if (count < k) {
                kthSmallest(root.right, k);
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
    
        public static void main(String[] args) {
            int values[] = {8, 5, 3, 1, 4, 6, 10, 11};
    
            Node root = null;
    
            for (int val : values) {
                root = insert(root, val);
            }
    
            int k = 3;
    
            kthSmallest(root, k);
    
            if (ans != -1) {
                System.out.println("Kth Smallest Element: " + ans);
            }
            else {
                System.out.println("Invalid K");
            }
        }
    }



