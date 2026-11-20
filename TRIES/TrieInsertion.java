 public class TrieInsertion {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    static Node root = new Node();

    public static void insert(String word) {

        Node curr = root;

        for (int level = 0; level < word.length(); level++) {

            int idx = word.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static void main(String[] args) {

        String words[] = {"apple", "app", "mango", "man"};

        for (String word : words) {
            insert(word);
        }

        System.out.println("All words inserted successfully!");
    }

}
