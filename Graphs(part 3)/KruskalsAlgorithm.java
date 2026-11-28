import java.util.*;

public class KruskalsAlgorithm {

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }

        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }

    static int[] par;
    static int[] rank;

    public static void init(int n) {
        par = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {

        int parA = find(a);
        int parB = find(b);

        if (parA == parB) {
            return;
        }

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } 
        else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } 
        else {
            par[parB] = parA;
        }
    }

    public static void kruskalsMST(ArrayList<Edge> edges, int V) {

        Collections.sort(edges);

        init(V);

        int mstCost = 0;
        int count = 0;

        for (int i = 0; i < edges.size(); i++) {

            Edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA != parB) {

                union(e.src, e.dest);

                mstCost += e.wt;
                count++;

                System.out.println(
                    e.src + " - " + e.dest + " : " + e.wt
                );

                if (count == V - 1) {
                    break;
                }
            }
        }

        if (count == V - 1) {
            System.out.println("Minimum Cost = " + mstCost);
        } else {
            System.out.println("MST is not possible");
        }
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));

        kruskalsMST(edges, V);
    }
}

