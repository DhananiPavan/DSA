class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;

        while (l < h) {
            int mid = (l + (h)) / 2;

            if (nums[mid] > nums[h]) {
                // min is in right half
                l = mid + 1;
            } else {
                // min is in left half (including mid)
                h = mid;
            }
        }

        return nums[l]; // or nums[h], both same
    }
}
