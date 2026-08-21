class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = (long) coins[0] * k;
        
        // Find minimum possible coin to minimize the search space upper bound
        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (countAmounts(mid, coins) >= k) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid amount
            } else {
                low = mid + 1; // Increase search range
            }
        }

        return ans;
    }

    // Counts how many distinct amounts <= target can be formed
    private long countAmounts(long target, int[] coins) {
        long count = 0;
        int n = coins.length;

        // Iterate through all 2^n - 1 non-empty subsets
        for (int mask = 1; mask < (1 << n); mask++) {
            long currentLcm = 1;
            int bitCount = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bitCount++;
                    currentLcm = lcm(currentLcm, coins[i]);
                    
                    // Stop if LCM exceeds target to prevent overflow
                    if (currentLcm > target) break;
                }
            }

            if (currentLcm <= target) {
                if (bitCount % 2 == 1) {
                    count += target / currentLcm;
                } else {
                    count -= target / currentLcm;
                }
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
