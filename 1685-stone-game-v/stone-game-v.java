class Solution {
    private int[][] memo;
    private int[] prefixSum;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        prefixSum = new int[n + 1];

        // Compute prefix sums for O(1) range sum queries
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        return solve(0, n - 1);
    }

    private int solve(int left, int right) {
        // Base case: 1 stone left, game ends, 0 points earned
        if (left == right) {
            return 0;
        }

        // Return cached result
        if (memo[left][right] != 0) {
            return memo[left][right];
        }

        int maxScore = 0;

        // Try all possible partition points i between [left, right - 1]
        for (int i = left; i < right; i++) {
            int leftSum = prefixSum[i + 1] - prefixSum[left];
            int rightSum = prefixSum[right + 1] - prefixSum[i + 1];

            if (leftSum < rightSum) {
                // Bob throws away the right row (larger sum)
                maxScore = Math.max(maxScore, leftSum + solve(left, i));
            } else if (rightSum < leftSum) {
                // Bob throws away the left row (larger sum)
                maxScore = Math.max(maxScore, rightSum + solve(i + 1, right));
            } else {
                // Sums are equal: Alice decides which row Bob throws away
                int keepLeft = leftSum + solve(left, i);
                int keepRight = rightSum + solve(i + 1, right);
                maxScore = Math.max(maxScore, Math.max(keepLeft, keepRight));
            }
        }

        return memo[left][right] = maxScore;
    }
}