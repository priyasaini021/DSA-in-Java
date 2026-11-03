 import java.util.*;

public class DuplicateParentheses {

    public static boolean hasDuplicate(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {
                int count = 0;

                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    count++;
                }

                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();

                if (count < 1) {
                    return true;
                }
            } 
            else {
                stack.push(ch);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b))";

        if (hasDuplicate(str)) {
            System.out.println("Duplicate Parentheses Found");
        } else {
            System.out.println("No Duplicate Parentheses");
        }
    }
}
    

