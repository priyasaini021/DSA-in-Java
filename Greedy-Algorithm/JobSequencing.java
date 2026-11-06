import java.util.*;

public class JobSequencing {
    public static void main(String[] args) {
        int jobs[][] = {
            {4, 20},
            {1, 10},
            {1, 40},
            {1, 30}
        };

        Arrays.sort(jobs,
            (a, b) -> b[1] - a[1]);

        int maxDeadline = 0;

        for (int i = 0; i < jobs.length; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][0]);
        }

        boolean slots[] = new boolean[maxDeadline + 1];

        int count = 0;
        int profit = 0;

        for (int i = 0; i < jobs.length; i++) {
            for (int j = jobs[i][0]; j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    count++;
                    profit += jobs[i][1];
                    break;
                }
            }
        }

        System.out.println("Jobs Done: " + count);
        System.out.println("Maximum Profit: " + profit);
    }
}