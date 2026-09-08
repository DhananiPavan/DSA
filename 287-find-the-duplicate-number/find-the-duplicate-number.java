class Solution {
    public int findDuplicate(int[] nums) {
        // Initialize pointers by taking the first step explicitly
        int slow = nums[0];
        int fast = nums[nums[0]];

        // Phase 1: Find the intersection point of the cycle
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Phase 2: Find the entrance to the cycle (the duplicate number)
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}