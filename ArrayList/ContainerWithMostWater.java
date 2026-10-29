 import java.util.ArrayList;

public class ContainerWithMostWater {
    public static int maxWater(ArrayList<Integer> height) {
        int left = 0;
        int right = height.size() - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;

            int minHeight = Math.min(
                height.get(left),
                height.get(right)
            );

            int water = width * minHeight;
            maxWater = Math.max(maxWater, water);

            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();

        int[] values = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        for (int value : values) {
            height.add(value);
        }

        System.out.println("Heights: " + height);
        System.out.println("Maximum Water: " + maxWater(height));
    }
}

