class Solution {
    public int maxDepth(String s) {
           int maxDepth = 0;
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cur++;
                if (cur > maxDepth) maxDepth = cur;
            } else if (c == ')') {
                cur--;
                // optionally: if (cur < 0) handle invalid input
            }
        }
        return maxDepth;
    }
}