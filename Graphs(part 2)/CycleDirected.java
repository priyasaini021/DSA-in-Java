import java.util.*;

public class CycleDirected {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));

        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));

        graph[2].add(new Edge(2, 3));
    }

    public static boolean isCycle(
        ArrayList<Edge>[] graph,
        int curr,
        boolean vis[],
        boolean rec[]
    ) {

        vis[curr] = true;

        rec[curr] = true;

        for (Edge e : graph[curr]) {

            if (!vis[e.dest]) {

                if (isCycle(graph, e.dest, vis, rec)) {
                    return true;
                }

            } else if (rec[e.dest]) {

                return true;
            }
        }

        rec[curr] = false;

        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        boolean vis[] = new boolean[V];

        boolean rec[] = new boolean[V];

        boolean cycle = false;

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                if (isCycle(graph, i, vis, rec)) {
                    cycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle Exists: " + cycle);
    }
}

