class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        
        // Step 1: Count frequency of each number
        int[] f = new int[max + 1];
        for (int x : nums) {
            f[x]++;
        }
        
        // Step 2: Calculate prefix sums
        // f[i] will store the total count of numbers <= i
        for (int i = 1; i <= max; i++) {
            f[i] += f[i - 1];
        }
        
        // Step 3: Map original elements to counts of smaller numbers
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = f[nums[i] - 1]; // Numbers strictly smaller than nums[i]
            }
        }
        
        return result;
    }
}