 import java.util.*;

public class BipartiteGraph {
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

        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        graph[1].add(new Edge(1, 3));
        graph[3].add(new Edge(3, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {

        int color[] = new int[graph.length];

        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {

            if (color[i] == -1) {

                q.add(i);

                color[i] = 0;

                while (!q.isEmpty()) {

                    int curr = q.remove();

                    for (Edge e : graph[curr]) {

                        if (color[e.dest] == -1) {

                            color[e.dest] = 1 - color[curr];

                            q.add(e.dest);

                        } else if (color[e.dest] == color[curr]) {

                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(
            "Is Bipartite: " + isBipartite(graph)
        );
    }
}

