import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int prefixSum = 0;
        int result = Integer.MAX_VALUE;
        int currentMinLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            
            // If a valid subarray ending at index i with sum equal to target exists
            if (map.containsKey(prefixSum - target)) {
                int start = map.get(prefixSum - target);
                int len = i - start;
                
                // If there's a valid subarray before `start + 1`, try updating result
                if (start >= 0 && minLen[start] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + minLen[start]);
                }
                
                currentMinLen = Math.min(currentMinLen, len);
            }
            
            // Store the minimum length of valid subarray ending at or before index i
            minLen[i] = currentMinLen;
            map.put(prefixSum, i);
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}