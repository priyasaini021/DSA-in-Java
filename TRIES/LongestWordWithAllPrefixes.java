 public class LongestWordWithAllPrefixes {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    static Node root = new Node();

    static String ans = "";

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

    public static void findLongestWord(Node root, StringBuilder temp) {

        for (int i = 0; i < 26; i++) {

            if (root.children[i] != null &&
                root.children[i].eow) {

                char ch = (char) (i + 'a');

                temp.append(ch);

                if (temp.length() > ans.length() ||
                   (temp.length() == ans.length() &&
                    temp.toString().compareTo(ans) < 0)) {

                    ans = temp.toString();
                }

                findLongestWord(root.children[i], temp);

                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {

        String words[] = {
            "a", "banana", "app", "ap",
            "appl", "apply", "apple"
        };

        for (String word : words) {
            insert(word);
        }

        findLongestWord(root, new StringBuilder());

        System.out.println("Longest Word: " + ans);
    }
}

