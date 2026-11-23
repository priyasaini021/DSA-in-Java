 import java.util.*;

public class ConnectedComponents {
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

        // Component 1
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        // Component 2
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

        // Vertex 5 is isolated
    }

    public static void dfs(
        ArrayList<Edge>[] graph,
        int curr,
        boolean vis[]
    ) {

        System.out.print(curr + " ");

        vis[curr] = true;

        for (Edge e : graph[curr]) {

            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        boolean vis[] = new boolean[V];

        int count = 0;

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                count++;

                System.out.print("Component " + count + ": ");

                dfs(graph, i, vis);

                System.out.println();
            }
        }

        System.out.println("Total Connected Components: " + count);
    }
}

