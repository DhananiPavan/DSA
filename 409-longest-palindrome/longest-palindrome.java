class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Check for Uppercase A-Z (ASCII 65-90)
            if (ch >= 'A' && ch <= 'Z') {
                freq[ch - 'A']++;
            }
            // Check for Lowercase a-z (ASCII 97-122)
            else if (ch >= 'a' && ch <= 'z') {
                freq[ch - 'a' + 26]++;
            }
        }
        int maxodd = 0;
        int maxeven = 0;
        boolean flag=false;
        for (int x : freq) {
            if ((x & 1) == 1 ) {
                maxodd+=x-1;
                flag=true;
            } else {
                maxeven += x;
            }
        }
        return flag?maxodd + maxeven+1:maxodd+maxeven;

    }
}