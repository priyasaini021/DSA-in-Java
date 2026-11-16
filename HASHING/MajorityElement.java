import java.util.HashMap;

public class MajorityElement {
    public static int majorityElement(int nums[]) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        // Count frequency
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

            // Check majority element
            if (map.get(nums[i]) > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 2, 2, 2};
        int ans = majorityElement(nums);

        if (ans != -1) {
            System.out.println("Majority Element: " + ans);
        } else {
            System.out.println("No Majority Element");
        }
    }
}
