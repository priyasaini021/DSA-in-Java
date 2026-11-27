
    import java.util.*;

public class PrimsAlgorithm {

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
        int cost;

        Pair(int n, int c) {
            node = n;
            cost = c;
        }

        public int compareTo(Pair p) {
            return this.cost - p.cost;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 0, 10));

        graph[0].add(new Edge(0, 2, 6));
        graph[2].add(new Edge(2, 0, 6));

        graph[0].add(new Edge(0, 3, 5));
        graph[3].add(new Edge(3, 0, 5));

        graph[1].add(new Edge(1, 3, 15));
        graph[3].add(new Edge(3, 1, 15));

        graph[2].add(new Edge(2, 3, 4));
        graph[3].add(new Edge(3, 2, 4));
    }

    static void prims(ArrayList<Edge>[] graph) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        boolean visited[] = new boolean[graph.length];

        pq.add(new Pair(0, 0));

        int mstCost = 0;

        System.out.println("Edges in MST:");

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (visited[curr.node]) {
                continue;
            }

            visited[curr.node] = true;

            mstCost += curr.cost;

            System.out.println(
                "Vertex: " + curr.node +
                ", Cost: " + curr.cost
            );

            for (Edge e : graph[curr.node]) {

                if (!visited[e.dest]) {

                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("Minimum Cost = " + mstCost);
    }

    public static void main(String args[]) {

        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        prims(graph);
    }
}

