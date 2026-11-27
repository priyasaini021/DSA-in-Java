
    import java.util.*;

public class CheapestFlights {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    static int cheapestFlight(
            int n,
            int flights[][],
            int src,
            int dest,
            int k) {

        int dist[] = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for (int i = 0; i <= k; i++) {

            int temp[] = dist.clone();

            for (int flight[] : flights) {

                int u = flight[0];
                int v = flight[1];
                int wt = flight[2];

                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + wt < temp[v]) {

                    temp[v] = dist[u] + wt;
                }
            }

            dist = temp;
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dest];
    }

    public static void main(String args[]) {

        int n = 4;

        int flights[][] = {
            {0, 1, 100},
            {1, 2, 100},
        };
    }
}
