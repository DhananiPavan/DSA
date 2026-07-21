class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int x : nums) {
            if (x >= 10 && x <= 99 ||
                    x >= 1000 && x <= 9999 ||
                    x >= 100000 && x <= 999999) {
                count++;
            }
        }
        return count;
    }
}