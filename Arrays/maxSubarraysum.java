public class maxSubarraysum {
    public static void maxSubarraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                int sum = 0;

                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }

                maxSum = Math.max(maxSum, sum);
            }
        }

        System.out.println("Maximum subarray sum = " + maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 6, -1, 3};
        maxSubarraySum(arr);
    }
}
