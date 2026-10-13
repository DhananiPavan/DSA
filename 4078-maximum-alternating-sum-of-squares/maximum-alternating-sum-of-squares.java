import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        // Map numbers to their squared values
        long[] squared = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            squared[i] = (long) nums[i] * nums[i];
        }
        
        // Sort the squared values in ascending order
        Arrays.sort(squared);
        
        long p = 0; // Positive contributions (even indices)
        long n = 0; // Negative contributions (odd indices)
        
        int left = 0;
        int right = squared.length - 1;
        
        // Alternate picking the largest and smallest squared values
        for (int i = 0; i < squared.length; i++) {
            if (i % 2 == 0) {
                // Even index gets the largest squared value
                p += squared[right];
                right--;
            } else {
                // Odd index gets the smallest squared value
                n += squared[left];
                left++;
            }
        }
        
        return p - n;
    }
}