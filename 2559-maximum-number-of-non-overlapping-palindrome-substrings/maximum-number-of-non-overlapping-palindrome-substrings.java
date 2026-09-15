class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int n = s.length();
        int lastEnd = -1; // End index of the previously chosen palindrome

        for (int i = 0; i < n; i++) {
            // Center can be single character (i, i) or a pair (i, i + 1)
            for (int j = i; j <= i + 1; j++) {
                int left = i;
                int right = j;

                while (left > lastEnd && right < n && s.charAt(left) == s.charAt(right)) {
                    // Check if current palindrome length reaches at least k
                    if (right - left + 1 >= k) {
                        count++;
                        lastEnd = right; // Greedily commit to this palindrome
                        break;
                    }
                    left--;
                    right++;
                }

                // If we found a palindrome starting at center i, jump to next center position
                if (lastEnd >= i) {
                    break;
                }
            }
        }

        return count;
    }
}