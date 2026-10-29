 import java.util.ArrayList;

public class PairSum {
    public static boolean pairSum(
            ArrayList<Integer> list, int target) {

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int sum = list.get(left) + list.get(right);

            if (sum == target) {
                System.out.println(
                    "Pair Found: " + list.get(left)
                    + " + " + list.get(right)
                );
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("Pair Not Found");
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);

        pairSum(list, 5);
    }
}

