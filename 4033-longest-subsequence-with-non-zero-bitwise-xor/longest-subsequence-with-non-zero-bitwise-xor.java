class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXOR = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            totalXOR ^= num;
            if (num != 0) {
                hasNonZero = true;
            }
        }

        // Case 1: All elements are 0
        if (!hasNonZero) {
            return 0;
        }

        // Case 2: Overall XOR is non-zero -> take full array
        // Case 3: Overall XOR is zero -> remove 1 non-zero element
        return totalXOR != 0 ? nums.length : nums.length - 1;
    }
}