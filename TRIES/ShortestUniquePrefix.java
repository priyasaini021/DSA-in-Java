 public class ShortestUniquePrefix {

    static class Node {
        Node[] children = new Node[26];
        int freq = 0;
    }

    static Node root = new Node();

    public static void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr.children[idx].freq++;

            curr = curr.children[idx];
        }
    }

    public static String findPrefix(String word) {

        Node curr = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';

            prefix.append(word.charAt(i));

            curr = curr.children[idx];

            if (curr.freq == 1) {
                break;
            }
        }

        return prefix.toString();
    }

    public static void main(String[] args) {

        String words[] = {"zebra", "dog", "duck", "dove"};

        for (String word : words) {
            insert(word);
        }

        for (String word : words) {
            System.out.println(findPrefix(word));
        }
    }
}

