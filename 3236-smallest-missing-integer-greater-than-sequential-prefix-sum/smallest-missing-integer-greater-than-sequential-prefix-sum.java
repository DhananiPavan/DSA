class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        int i = 1;
        int sum = nums[0];

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Find sum of consecutive prefix
        while (i < n && nums[i - 1] == nums[i] - 1) {
            sum += nums[i];
            i++;
        }

        // Find the smallest missing integer >= sum
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}