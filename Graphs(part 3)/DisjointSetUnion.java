 public class DisjointSetUnion {

    static int[] par;
    static int[] rank;

    // Initialize DSU
    public static void init(int n) {
        par = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    // Find with Path Compression
    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    // Union by Rank
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

    public static void main(String[] args) {

        init(7);

        union(1, 3);
        union(2, 4);
        union(3, 6);
        union(1, 2);

        System.out.println(find(3));
        System.out.println(find(4));

        System.out.println(find(1) == find(4));
        System.out.println(find(1) == find(5));
    }

}
