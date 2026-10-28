public class FindPermutations {
    public static void findPermutations(String str, String ans) {
        // Base case
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }

        // Try every character at the current position
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            String remaining = str.substring(0, i)
                    + str.substring(i + 1);

            findPermutations(remaining, ans + current);
        }
    }

    public static void main(String[] args) {
        String str = "abc";

        findPermutations(str, "");
    }
}

