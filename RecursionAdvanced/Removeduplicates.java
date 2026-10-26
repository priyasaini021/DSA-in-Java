public class Removeduplicates {
    public static void removeDuplicates(
            String str, int index,
            StringBuilder result, boolean[] seen) {

        // Base case
        if (index == str.length()) {
            System.out.println(result);
            return;
        }

        char current = str.charAt(index);

        if (!seen[current]) {
            seen[current] = true;
            result.append(current);
        }

        removeDuplicates(str, index + 1, result, seen);
    }

    public static void main(String[] args) {
        String str = "programming";

        boolean[] seen = new boolean[Character.MAX_VALUE + 1];

        removeDuplicates(
            str, 0, new StringBuilder(), seen
        );
    }
}

