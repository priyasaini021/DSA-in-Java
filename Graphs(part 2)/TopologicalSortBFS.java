 import java.util.*;

public class TopologicalSortBFS {
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

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    static void calculateIndegree(ArrayList<Edge>[] graph, int indegree[]) {

        for (int i = 0; i < graph.length; i++) {

            for (Edge e : graph[i]) {
                indegree[e.dest]++;
            }
        }
    }

    static void topologicalSort(ArrayList<Edge>[] graph) {

        int indegree[] = new int[graph.length];

        calculateIndegree(graph, indegree);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {

            int curr = q.remove();

            System.out.print(curr + " ");

            count++;

            for (Edge e : graph[curr]) {

                indegree[e.dest]--;

                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        if (count != graph.length) {
            System.out.println("\nTopological sorting is not possible (Cycle exists).");
        }
    }

    public static void main(String args[]) {

        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println("Topological Sorting using BFS:");

        topologicalSort(graph);
    }
}

