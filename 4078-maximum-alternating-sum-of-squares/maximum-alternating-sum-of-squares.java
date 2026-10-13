import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        long[] squared = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            squared[i] = (long) nums[i] * nums[i];
        }
        
        
        Arrays.sort(squared);
        
        long p = 0; 
        long n = 0;
        
        int left = 0;
        int right = squared.length - 1;
        
       
        for (int i = 0; i < squared.length; i++) {
            if (i % 2 == 0) {
                
                p += squared[right];
                right--;
            } else {
               
                n += squared[left];
                left++;
            }
        }
        
        return p - n;
    }
}