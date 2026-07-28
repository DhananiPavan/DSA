class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        // Count frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder half = new StringBuilder();
        char middle = '\0';

        // Build first half in lexicographical order
        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                middle = (char) ('a' + i);
            }

            for (int j = 0; j < freq[i] / 2; j++) {
                half.append((char) ('a' + i));
            }
        }

        StringBuilder ans = new StringBuilder();

        ans.append(half);

        if (middle != '\0') {
            ans.append(middle);
        }

        ans.append(new StringBuilder(half).reverse());

        return ans.toString();
    }
}