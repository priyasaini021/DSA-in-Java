 import java.util.*;

public class ConnectingCities {

    static class Pair implements Comparable<Pair> {

        int city;
        int cost;

        Pair(int c, int wt) {
            city = c;
            cost = wt;
        }

        public int compareTo(Pair p) {
            return this.cost - p.cost;
        }
    }

    static int connectingCities(int cities[][]) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        boolean visited[] = new boolean[cities.length];

        pq.add(new Pair(0, 0));

        int totalCost = 0;
        int count = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (visited[curr.city]) {
                continue;
            }

            visited[curr.city] = true;

            totalCost += curr.cost;
            count++;

            for (int i = 0; i < cities.length; i++) {

                if (cities[curr.city][i] != 0 &&
                    !visited[i]) {

                    pq.add(new Pair(i, cities[curr.city][i]));
                }
            }
        }

        if (count != cities.length) {
            return -1;
        }

        return totalCost;
    }

    public static void main(String args[]) {

        int cities[][] = {
            {0, 1, 2, 3, 0},
            {1, 0, 0, 4, 0},
            {2, 0, 0, 5, 0},
            {3, 4, 5, 0, 6},
            {0, 0, 0, 6, 0}
        };

        int ans = connectingCities(cities);

        System.out.println("Minimum Cost to Connect Cities: " + ans);
    }
}

