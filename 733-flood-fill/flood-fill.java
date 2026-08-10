class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];

        if (oldColor == color) {
            return image;
        }

        dfs(image, sr, sc, oldColor, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int color) {

        // Out of bounds
        if (r < 0 || r >= image.length ||
            c < 0 || c >= image[0].length) {
            return;
        }

        // Not part of the original connected region
        if (image[r][c] != oldColor) {
            return;
        }

        // Change color
        image[r][c] = color;

        // Up
        dfs(image, r - 1, c, oldColor, color);

        // Down
        dfs(image, r + 1, c, oldColor, color);

        // Left
        dfs(image, r, c - 1, oldColor, color);

        // Right
        dfs(image, r, c + 1, oldColor, color);
    }
}