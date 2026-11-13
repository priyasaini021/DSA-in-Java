import java.util.*;
    
    public class TwoSumBST {
        static class Node {
            int data;
            Node left, right;
    
            Node(int data) {
                this.data = data;
            }
        }
    
        public static void inorder(Node root, ArrayList<Integer> list) {
            if (root == null) {
                return;
            }
    
            inorder(root.left, list);
    
            list.add(root.data);
    
            inorder(root.right, list);
        }
    
        public static boolean findTarget(Node root, int target) {
            ArrayList<Integer> list = new ArrayList<>();
    
            inorder(root, list);
    
            int left = 0;
            int right = list.size() - 1;
    
            while (left < right) {
    
                int sum = list.get(left) + list.get(right);
    
                if (sum == target) {
                    return true;
                }
    
                else if (sum < target) {
                    left++;
                }
    
                else {
                    right--;
                }
            }
    
            return false;
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
    
            int target = 14;
    
            if (findTarget(root, target)) {
                System.out.println("Pair Found");
            }
            else {
                System.out.println("Pair Not Found");
            }
        }
    }



