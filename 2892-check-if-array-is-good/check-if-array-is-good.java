import java.util.Arrays;

class Solution {
    public boolean isGood(int[] nums) {
        int len = nums.length;
        // Since base[n] has n+1 elements, the max element n must be len - 1
        int n = len - 1;
        
        // A "good" array must have at least 2 elements (base[1] = [1, 1])
        if (len < 2) return false;

        Arrays.sort(nums);

        // Check if all elements from index 0 to n-1 follow the [1, 2, ..., n] pattern
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }

        // The very last element must also be n (creating the double n at the end)
        return nums[n] == n;
    }
}