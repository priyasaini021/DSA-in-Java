import java.util.*;
     public class LevelOrder {
      static class Node {
            int data;
            Node left, right;
    
            Node(int data) {
                this.data = data;
            }
        }
    
        public static void levelOrder(Node root) {
    
            if (root == null) {
                return;
            }
    
            Queue<Node> q = new LinkedList<>();
            q.add(root);
    
            while (!q.isEmpty()) {
    
                Node curr = q.remove();
                System.out.print(curr.data + " ");
    
                if (curr.left != null) {
                    q.add(curr.left);
                }
    
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    
        public static void main(String[] args) {
    
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
    
            System.out.print("Level Order Traversal: ");
            levelOrder(root);
        }
    }


