class Solution {
    private Boolean[][][] memo;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Path length must be even for valid matching parentheses
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // The starting bracket must be '(' and ending bracket must be ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        // Maximum possible open brackets in a valid path is (m + n) / 2
        int maxOpen = (m + n) / 2;
        memo = new Boolean[m][n][maxOpen + 1];

        return dfs(0, 0, 0, grid);
    }

    private boolean dfs(int r, int c, int openCount, char[][] grid) {
    if (grid[r][c] == '(') {
        openCount++;
    } else {
        openCount--;
    }

    // Invalid if close brackets exceed open ones OR if open brackets exceed half the total path length
    if (openCount < 0 || openCount > (m + n) / 2) {
        return false;
    }

    // If we reach the bottom-right cell
    if (r == m - 1 && c == n - 1) {
        return openCount == 0;
    }

    // Return cached result if available
    if (memo[r][c][openCount] != null) {
        return memo[r][c][openCount];
    }

    boolean found = false;

    // Move Down
    if (r + 1 < m) {
        found = dfs(r + 1, c, openCount, grid);
    }

    // Move Right
    if (!found && c + 1 < n) {
        found = dfs(r, c + 1, openCount, grid);
    }

    return memo[r][c][openCount] = found;
}
}