  import java.util.ArrayList;

public class PairSum2 {
    public static boolean pairSum(
            ArrayList<Integer> list, int target) {

        int n = list.size();

        if (n < 2) {
            return false;
        }

        int breakingPoint = -1;

        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get((i + 1) % n)) {
                breakingPoint = i;
                break;
            }
        }

        int left = (breakingPoint + 1) % n;
        int right = breakingPoint;

        while (left != right) {
            int sum = list.get(left) + list.get(right);

            if (sum == target) {
                System.out.println(
                    "Pair Found: " + list.get(left)
                    + " + " + list.get(right)
                );
                return true;
            }

            if (sum < target) {
                left = (left + 1) % n;
            } else {
                right = (n + right - 1) % n;
            }
        }

        System.out.println("Pair Not Found");
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        int[] values = {11, 15, 6, 8, 9, 10};

        for (int value : values) {
            list.add(value);
        }

        pairSum(list, 16);
    }
}
