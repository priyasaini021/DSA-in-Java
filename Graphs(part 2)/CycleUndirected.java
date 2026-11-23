import java.util.*;

public class CycleUndirected {
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
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 0));
        graph[0].add(new Edge(0, 2));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
    }

    public static boolean isCycle(
        ArrayList<Edge>[] graph,
        boolean vis[],
        int curr,
        int par
    ) {

        vis[curr] = true;

        for (Edge e : graph[curr]) {

            if (!vis[e.dest]) {

                if (isCycle(graph, vis, e.dest, curr)) {
                    return true;
                }

            } else if (e.dest != par) {

                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        boolean vis[] = new boolean[V];

        boolean cycle = false;

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                if (isCycle(graph, vis, i, -1)) {
                    cycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle Exists: " + cycle);
    }
}
