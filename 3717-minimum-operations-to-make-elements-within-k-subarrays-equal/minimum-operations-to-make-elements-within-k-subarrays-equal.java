import java.util.*;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] windowCost = new long[n - x + 1];
        
        // We use two TreeMap-backed multisets (or equivalent tracking) 
        // to get O(log x) insertions, deletions, and median tracking.
        // For simplicity of standard Java, we can implement two TreeMaps representing:
        // leftMap: stores smaller half (size = (x + 1) / 2)
        // rightMap: stores larger half (size = x / 2)
        
        TreeMap<Long, Integer> leftMap = new TreeMap<>();
        TreeMap<Long, Integer> rightMap = new TreeMap<>();
        
        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;
        
        for (int i = 0; i < n; i++) {
            long val = nums[i];
            
            // 1. Insert element
            if (leftMap.isEmpty() || val <= leftMap.lastKey()) {
                leftMap.put(val, leftMap.getOrDefault(val, 0) + 1);
                leftSum += val;
                leftSize++;
            } else {
                rightMap.put(val, rightMap.getOrDefault(val, 0) + 1);
                rightSum += val;
                rightSize++;
            }
            
            // 2. Balance sizes
            int targetLeftSize = (x + 1) / 2;
            while (leftSize > targetLeftSize) {
                long key = leftMap.lastKey();
                int count = leftMap.get(key);
                leftSum -= key * count;
                leftSize -= count;
                leftMap.remove(key);
                
                rightMap.put(key, rightMap.getOrDefault(key, 0) + count);
                rightSum += key * count;
                rightSize += count;
            }
            while (leftSize < targetLeftSize && !rightMap.isEmpty()) {
                long key = rightMap.firstKey();
                int count = rightMap.get(key);
                rightSum -= key * count;
                rightSize -= count;
                rightMap.remove(key);
                
                leftMap.put(key, leftMap.getOrDefault(key, 0) + count);
                leftSum += key * count;
                leftSize += count;
            }
            
            // 3. Process full window
            if (i >= x - 1) {
                long median = leftMap.lastKey();
                // Mathematical cost calculation in O(1) using running sums:
                // cost = (rightSum - median * rightSize) + (median * leftSize - leftSum)
                long cost = (rightSum - median * rightSize) + (median * leftSize - leftSum);
                windowCost[i - x + 1] = cost;
                
                // 4. Remove outgoing element
                long removeVal = nums[i - x + 1];
                if (leftMap.containsKey(removeVal)) {
                    int count = leftMap.get(removeVal);
                    leftSum -= removeVal;
                    leftSize--;
                    if (count == 1) leftMap.remove(removeVal);
                    else leftMap.put(removeVal, count - 1);
                } else {
                    int count = rightMap.get(removeVal);
                    rightSum -= removeVal;
                    rightSize--;
                    if (count == 1) rightMap.remove(removeVal);
                    else rightMap.put(removeVal, count - 1);
                }
                
                // Re-balance after removal
                while (leftSize > targetLeftSize) {
                    long key = leftMap.lastKey();
                    int count = leftMap.get(key);
                    leftSum -= key * count;
                    leftSize -= count;
                    leftMap.remove(key);
                    
                    rightMap.put(key, rightMap.getOrDefault(key, 0) + count);
                    rightSum += key * count;
                    rightSize += count;
                }
                while (leftSize < targetLeftSize && !rightMap.isEmpty()) {
                    long key = rightMap.firstKey();
                    int count = rightMap.get(key);
                    rightSum -= key * count;
                    rightSize -= count;
                    rightMap.remove(key);
                    
                    leftMap.put(key, leftMap.getOrDefault(key, 0) + count);
                    leftSum += key * count;
                    leftSize += count;
                }
            }
        }
        
        // Step 2: DP to find minimum cost of k non-overlapping windows (remains the same)
        long[][] dp = new long[n + 1][k + 1];
        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        
        for (int j = 1; j <= k; j++) {
            long minPrev = Long.MAX_VALUE / 2;
            for (int i = 1; i <= n; i++) {
                if (i >= x) {
                    int startIdx = i - x;
                    minPrev = Math.min(minPrev, dp[startIdx][j - 1] + windowCost[startIdx]);
                }
                dp[i][j] = Math.min(dp[i - 1][j], minPrev);
            }
        }
        
        return dp[n][k];
    }
}