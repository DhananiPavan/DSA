class Solution {
    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n];

        // Suffix sum
        suffix[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        // -1 means not calculated
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        return solve(0, 1);
    }

    private int solve(int i, int M) {
        // Take all remaining piles
        if (i >= n) {
            return 0;
        }

        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int best = 0;

        // Try taking 1 to 2*M piles
        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int newM = Math.max(M, X);

            int current = suffix[i]
                         - solve(i + X, newM);

            best = Math.max(best, current);
        }

        return dp[i][M] = best;
    }
}