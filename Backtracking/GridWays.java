 public class GridWays {
    public static int countWays(int row, int col, int n, int m) {

        // Destination reached
        if (row == n - 1 && col == m - 1) {
            return 1;
        }

        // Out of bounds
        if (row >= n || col >= m) {
            return 0;
        }

        // Move down
        int downWays = countWays(row + 1, col, n, m);

        // Move right
        int rightWays = countWays(row, col + 1, n, m);

        return downWays + rightWays;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;

        System.out.println(
            "Total ways: " + countWays(0, 0, n, m)
        );
    }
}

