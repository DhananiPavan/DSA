class Solution {
    public long countCommas(long n) {
        if (n < 1000L) {
            return 0L;
        }

        long ans = 0L;

        if (n >= 1000L) {
            long temp=Math.min(n,999999L);
            ans += temp - 999L;
        }

        if (n >= 1000000L) {
            long temp=Math.min(n,999999999L);
            ans += 2L * (temp - 999999L);
        }

        if (n >=1000000000L) {
             long temp=Math.min(n,999999999999L);
            ans += 3L * (temp - 999999999L);
        }

        if (n >= 1000000000000L) {
             long temp=Math.min(n,999999999999999L);
            ans += 4L * (temp - 999999999999L);
        }

        if (n >= 1000000000000000L) {
            long temp=Math.min(n,999999999999999999L);

            ans += 5L * (temp - 999999999999999L);
        }

        return ans;
    }
}