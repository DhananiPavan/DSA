class Solution {
    public static int maxProduct(int[] arr) {
        int n = arr.length; //size of array.

        int pre = 1, suff = 1;
        int ans = arr[0];
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= arr[i];
            suff *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }
}