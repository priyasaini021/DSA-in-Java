 public class TrieCreation {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

    public static void main(String[] args) {

        System.out.println("Trie Created Successfully!");

        if (root != null) {
            System.out.println("Root node exists.");
        }
    }
}

