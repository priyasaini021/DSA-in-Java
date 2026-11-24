 import java.util.*;

public class TopologicalsortDFS {

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

    static void topologicalSortUtil(
            ArrayList<Edge>[] graph,
            int curr,
            boolean visited[],
            Stack<Integer> stack) {

        visited[curr] = true;

        for (Edge e : graph[curr]) {

            if (!visited[e.dest]) {
                topologicalSortUtil(graph, e.dest, visited, stack);
            }
        }

        stack.push(curr);
    }

    static void topologicalSort(ArrayList<Edge>[] graph) {

        boolean visited[] = new boolean[graph.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String args[]) {

        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println("Topological Sorting using DFS:");

        topologicalSort(graph);
    }
}

