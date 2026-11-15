 import java.util.*;
public class SlidingWindowMaximum {
    static class Pair implements Comparable<Pair> {

        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int compareTo(Pair p) {
            return p.value - this.value;
        }
    }

public static void slidingWindowMax(int arr[], int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int result[] = new int[arr.length - k + 1];

        // First window
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        result[0] = pq.peek().value;

        // Remaining windows
        for (int i = k; i < arr.length; i++) {

            // Remove elements outside current window
            while (!pq.isEmpty() && pq.peek().index <= i - k) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));

            result[i - k + 1] = pq.peek().value;
        }

        System.out.println("Maximum of each window:");

        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        slidingWindowMax(arr, k);
    }
}

