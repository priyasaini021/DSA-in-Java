public class TrieSearching {

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

    public static boolean search(String key) {

        Node curr = root;

        for (int level = 0; level < key.length(); level++) {

            int idx = key.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.eow;
    }

    public static void main(String[] args) {

        String words[] = {"apple", "app", "mango", "man"};

        for (String word : words) {
            insert(word);
        }

        System.out.println("Search apple: " + search("apple"));
        System.out.println("Search app: " + search("app"));
        System.out.println("Search mango: " + search("mango"));
        System.out.println("Search bat: " + search("bat"));
    }
}

