import java.util.*;

public class Dijkstra {

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

    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int n, int d) {
            node = n;
            dist = d;
        }

        public int compareTo(Pair p) {
            return this.dist - p.dist;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static void dijkstra(ArrayList<Edge>[] graph, int src) {

        int dist[] = new int[graph.length];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (curr.dist > dist[curr.node]) {
                continue;
            }

            for (Edge e : graph[curr.node]) {

                int u = e.src;
                int v = e.dest;

                int newDist = dist[u] + e.wt;

                if (newDist < dist[v]) {

                    dist[v] = newDist;

                    pq.add(new Pair(v, newDist));
                }
            }
        }

        System.out.println("Shortest Distance from Source " + src + ":");

        for (int i = 0; i < dist.length; i++) {

            System.out.println("0 to " + i + " = " + dist[i]);
        }
    }

    public static void main(String args[]) {

        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        dijkstra(graph, 0);
    }
}

