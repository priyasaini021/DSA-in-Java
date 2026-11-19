import java.util.HashMap;

public class LargestSubarraySumZero {
    public static int largestSubarray(int arr[]) {
     HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If prefix sum is zero
            if (sum == 0) {
                maxLength = i + 1;
            }

            // If prefix sum already exists
            if (map.containsKey(sum)) {

                int length = i - map.get(sum);

                maxLength = Math.max(maxLength, length);
            }

            else {

                // Store prefix sum and index
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

        int ans = largestSubarray(arr);

        System.out.println("Largest Subarray Length: " + ans);
    }
}

