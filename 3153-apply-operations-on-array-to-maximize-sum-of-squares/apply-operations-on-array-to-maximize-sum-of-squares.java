import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCounts = new int[32];
        
        // Count the frequency of each set bit across all numbers
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCounts[i]++;
                }
            }
        }
        
        long MOD = 1_000_000_007;
        long totalSumOfSquares = 0;
        
        // Greedily construct the top k largest numbers
        for (int step = 0; step < k; step++) {
            long currentVal = 0;
            for (int i = 0; i < 32; i++) {
                if (bitCounts[i] > 0) {
                    currentVal |= (1L << i);
                    bitCounts[i]--;
                }
            }
            totalSumOfSquares = (totalSumOfSquares + (currentVal * currentVal) % MOD) % MOD;
        }
        
        return (int) totalSumOfSquares;
    }
}