class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                // Since the array is 0-indexed in Java, 
                // the 1-indexed element nums[i] corresponds to nums[i - 1]
                int val = nums[i - 1];
                sum += val * val;
            }
        }
        
        return sum;
    }
}