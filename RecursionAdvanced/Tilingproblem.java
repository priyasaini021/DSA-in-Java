public class Tilingproblem {
   public static int tilingWays(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return tilingWays(n - 1) + tilingWays(n - 2);
    }

    public static void main(String[] args) {
        int n = 4;

        System.out.println(tilingWays(n));
    }
}

