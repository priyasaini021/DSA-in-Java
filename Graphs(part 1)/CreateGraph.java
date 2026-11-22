import java.util.*;

public class CreateGraph {

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

        // Vertex 0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // Vertex 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // Vertex 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // Vertex 3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        // Vertex 4
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        // Vertex 5
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        // Vertex 6
        graph[6].add(new Edge(6, 5));
    }

    public static void main(String[] args) {

        int V = 7;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        for (int i = 0; i < V; i++) {

            System.out.print("Vertex " + i + ": ");

            for (Edge e : graph[i]) {
                System.out.print(e.dest + " ");
            }

            System.out.println();
        }
    }
}

