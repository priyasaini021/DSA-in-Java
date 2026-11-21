 public class CountUniqueSubstrings {

    static class Node {
        Node[] children = new Node[26];

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

    public static void insert(String suffix) {

        Node curr = root;

        for (int i = 0; i < suffix.length(); i++) {

            int idx = suffix.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }
    }

    public static int countNodes(Node root) {

        if (root == null) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {

            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }

        return count + 1;
    }

    public static int countUniqueSubstrings(String str) {

        // Insert all suffixes

        for (int i = 0; i < str.length(); i++) {

            String suffix = str.substring(i);

            insert(suffix);
        }

        // Exclude root node (empty substring)

        return countNodes(root) - 1;
    }

    public static void main(String[] args) {

        String str = "ababa";

        System.out.println(
            "Unique Substrings: " + countUniqueSubstrings(str)
        );
    }
}

