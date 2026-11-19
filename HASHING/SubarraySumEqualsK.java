  import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int arr[], int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;

        // Initial prefix sum frequency
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {

            // Calculate prefix sum
            sum += arr[i];

            // Check required prefix sum
            if (map.containsKey(sum - k)) {

                count += map.get(sum - k);
            }

            // Update frequency
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int arr[] = {10, 2, -2, -20, 10};

        int k = -10;

        int ans = subarraySum(arr, k);

        System.out.println("Total Subarrays: " + ans);
    }
}

