  import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};

        int capacity = 50;

        double ratio[][] = new double[val.length][2];

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) val[i] / wt[i];
        }

        Arrays.sort(ratio,
            (a, b) -> Double.compare(b[1], a[1]));

        int totalValue = 0;

        for (int i = 0; i < ratio.length; i++) {
            int idx = (int) ratio[i][0];

            if (capacity >= wt[idx]) {
                capacity -= wt[idx];
                totalValue += val[idx];
            } else {
                totalValue += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println("Maximum Value: " + totalValue);
    }
}
