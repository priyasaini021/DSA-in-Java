 import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {

        // Check length
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters of first string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Decrease frequency using second string
        for (int i = 0; i < t.length(); i++) {

            char ch = t.charAt(i);

            if (!map.containsKey(ch)) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);

            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "race";
        String t = "care";

        if (isAnagram(s, t)) {
            System.out.println("Valid Anagram");
        } else {
            System.out.println("Not a Valid Anagram");
        }
    }
}

