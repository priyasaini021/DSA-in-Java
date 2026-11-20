 public class WordBreak {

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

    public static boolean wordBreak(String key) {

        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {

            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);

            if (search(firstPart) && wordBreak(secondPart)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String dictionary[] = {
            "i", "like", "sam", "sung", "samsung"
        };

        String key = "ilikesamsung";

        for (String word : dictionary) {
            insert(word);
        }

        System.out.println("Word Break: " + wordBreak(key));
    }
}

