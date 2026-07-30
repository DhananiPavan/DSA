class Solution {
    public int minimumPushes(String word) {
        int l = word.length();
        int perfect = l / 8;
        int extra = l % 8;
        int pre = 1;
        int ans = 0;
        while (perfect != 0) {
            ans += pre * 8;
            pre++;
            perfect--;

        }
        ans += pre * extra;
        return ans;
    }
}