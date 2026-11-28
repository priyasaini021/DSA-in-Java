 public class FloodFill {

    public static int[][] floodFill(
        int[][] image, int sr, int sc, int newColor) {

        int originalColor = image[sr][sc];

        if (originalColor == newColor) {
            return image;
        }

        dfs(image, sr, sc, originalColor, newColor);

        return image;
    }

    public static void dfs(
        int[][] image, int r, int c,
        int originalColor, int newColor) {

        int rows = image.length;
        int cols = image[0].length;

        // Boundary condition
        if (r < 0 || c < 0 ||
            r >= rows || c >= cols) {
            return;
        }

        // Check original color
        if (image[r][c] != originalColor) {
            return;
        }

        // Change color
        image[r][c] = newColor;

        // Up
        dfs(image, r - 1, c, originalColor, newColor);

        // Down
        dfs(image, r + 1, c, originalColor, newColor);

        // Left
        dfs(image, r, c - 1, originalColor, newColor);

        // Right
        dfs(image, r, c + 1, originalColor, newColor);
    }

    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] result = floodFill(
            image, sr, sc, newColor
        );

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

