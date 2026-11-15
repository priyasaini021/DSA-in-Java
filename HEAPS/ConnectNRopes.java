 import java.util.*;
public class ConnectNRopes {

    public static int minCost(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all ropes into Min Heap
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int cost = 0;

        while (pq.size() > 1) {

            int min1 = pq.remove();
            int min2 = pq.remove();

            int sum = min1 + min2;

            cost += sum;

            pq.add(sum);
        }

        return cost;
    }

    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 6};

        System.out.println("Minimum Cost = " + minCost(arr));
    }
}

