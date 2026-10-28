 public class FindSubsets {
  public static void findSubsets(String str, String ans, int index) {
          // Base case
        if (index == str.length()) {
            System.out.println(ans.isEmpty() ? "\"\"" : ans);
            return;
        }

        // Choice 1: Include current character
        findSubsets(str, ans + str.charAt(index), index + 1);

        // Choice 2: Exclude current character
        findSubsets(str, ans, index + 1);
    }

    public static void main(String[] args) {
        String str = "abc";

        findSubsets(str, "", 0);
    }
}

