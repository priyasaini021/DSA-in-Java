import java.util.*;

public class MaxAreaHistogram {

    public static int maxArea(int arr[]) {
        int maxArea = 0;
        int n = arr.length;

        int nsl[] = new int[n];
        int nsr[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Next Smaller Left
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        // Next Smaller Right
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = stack.peek();
            }

            stack.push(i);
        }

        // Calculate Maximum Area
        for (int i = 0; i < n; i++) {

            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;

            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int arr[] = {2, 1, 5, 6, 2, 3};

        System.out.println("Maximum Area = " + maxArea(arr));
    }
}

