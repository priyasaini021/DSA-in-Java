import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void nextGreater(int[] arr) {
        int n = arr.length;

        int[] result = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = s.peek();
            }

            s.push(arr[i]);
        }

        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};

        nextGreater(arr);
    }
}
