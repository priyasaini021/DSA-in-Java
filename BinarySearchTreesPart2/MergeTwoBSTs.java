 import java.util.*;
    
    public class MergeTwoBSTs {
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
    
        public static void inorder(Node root, ArrayList<Integer> list) {
            if (root == null) {
                return;
            }
    
            inorder(root.left, list);
    
            list.add(root.data);
    
            inorder(root.right, list);
        }
    
        public static ArrayList<Integer> merge(
                ArrayList<Integer> list1,
                ArrayList<Integer> list2) {
    
            ArrayList<Integer> result = new ArrayList<>();
    
            int i = 0;
            int j = 0;
    
            while (i < list1.size() && j < list2.size()) {
    
                if (list1.get(i) < list2.get(j)) {
                    result.add(list1.get(i));
                    i++;
                }
                else {
                    result.add(list2.get(j));
                    j++;
                }
            }
    
            while (i < list1.size()) {
                result.add(list1.get(i));
                i++;
            }
    
            while (j < list2.size()) {
                result.add(list2.get(j));
                j++;
            }
    
            return result;
        }
    
        public static Node createBST(
                ArrayList<Integer> list,
                int si,
                int ei) {
    
            if (si > ei) {
                return null;
            }
    
            int mid = si + (ei - si) / 2;
    
            Node root = new Node(list.get(mid));
    
            root.left = createBST(list, si, mid - 1);
            root.right = createBST(list, mid + 1, ei);
    
            return root;
        }
    
        public static void printInorder(Node root) {
            if (root == null) {
                return;
            }
    
            printInorder(root.left);
    
            System.out.print(root.data + " ");
    
            printInorder(root.right);
        }
    
        public static void main(String[] args) {
            Node root1 = null;
            Node root2 = null;
    
            int values1[] = {2, 1, 4};
            int values2[] = {9, 3, 12};
    
            for (int val : values1) {
                root1 = insert(root1, val);
            }
    
            for (int val : values2) {
                root2 = insert(root2, val);
            }
    
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
    
            inorder(root1, list1);
            inorder(root2, list2);
    
            ArrayList<Integer> merged = merge(list1, list2);
    
            Node root = createBST(merged, 0, merged.size() - 1);
    
            System.out.print("Merged BST Inorder: ");
            printInorder(root);
        }
    }


