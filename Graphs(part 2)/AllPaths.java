 import java.util.*;

public class AllPaths {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 5));
    }

    static void printAllPaths(
            ArrayList<Edge>[] graph,
            int curr,
            int target,
            String path) {

        if (curr == target) {
            System.out.println(path + target);
            return;
        }

        for (Edge e : graph[curr]) {

            printAllPaths(
                graph,
                e.dest,
                target,
                path + curr + " -> "
            );
        }
    }

    public static void main(String args[]) {

        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        int source = 0;
        int target = 5;

        System.out.println("All Paths from Source to Target:");

        printAllPaths(graph, source, target, "");
    }
}
