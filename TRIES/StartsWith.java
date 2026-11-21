 public class StartsWith {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    static Node root = new Node();

    public static void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean startsWith(String prefix) {

        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {

            int idx = prefix.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    public static void main(String[] args) {

        String words[] = {"apple", "app", "mango", "man"};

        for (String word : words) {
            insert(word);
        }

        System.out.println(startsWith("app"));
        System.out.println(startsWith("ma"));
        System.out.println(startsWith("bat"));
    }
}

