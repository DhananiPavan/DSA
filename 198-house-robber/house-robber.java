class Solution {

    public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);

        return solve(0, nums, dp);
    }

    int solve(int i, int[] nums, int[] dp) {

        // no houses left
        if (i >= nums.length) {
            return 0;
        }

        // already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // rob current
        int rob = nums[i] + solve(i + 2, nums, dp);

        // skip current
        int skip = solve(i + 1, nums, dp);

        // store and return
        dp[i] = Math.max(rob, skip);

        return dp[i];
    }
}