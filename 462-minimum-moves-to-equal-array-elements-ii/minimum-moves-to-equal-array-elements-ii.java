class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int ans = 0;
        while (l < r) {
            ans += Math.abs(nums[r] - nums[l]);
            l++;
            r--;
        }
        return ans;
    }
}