class Solution {
    public int stoneGameII(int[] piles) {
      int n = piles.length;
        int[] suffixSum = new int[n];
        
        // Calculate suffix sums to quickly get total stones remaining from index i
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        int[][] memo = new int[n][n + 1];
        return helper(piles, suffixSum, memo, 0, 1);
    }

    private int helper(int[] piles, int[] suffixSum, int[][] memo, int i, int M) {
        if (i >= piles.length) return 0;
        // If the current player can take all remaining piles, take them all
        if (i + 2 * M >= piles.length) return suffixSum[i];
        if (memo[i][M] != 0) return memo[i][M];

        int maxStones = 0;
        // Try taking X piles where 1 <= X <= 2 * M
        for (int X = 1; X <= 2 * M; X++) {
            int nextM = Math.max(M, X);
            // Current player's score = total remaining stones - opponent's best score from next state
            int opponentStones = helper(piles, suffixSum, memo, i + X, nextM);
            maxStones = Math.max(maxStones, suffixSum[i] - opponentStones);
        }

        memo[i][M] = maxStones;
        return maxStones;  
    }
}