import java.util.*;

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Check if palindrome is possible
        int oddCount = 0;
        int midChar = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                oddCount++;
                midChar = i;
            }
        }
        if (oddCount > 1) return "";

        // Available characters for the first half
        int[] halfCnt = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCnt[i] = cnt[i] / 2;
        }

        int m = n / 2;
        char[] prefix = new char[m];
        
        // Try to match prefix of target up to length i, then make index i larger
        String best = null;

        // Helper to check if a prefix can be completed
        for (int i = 0; i <= m; i++) {
            // Validate if target[0..i-1] can be formed using halfCnt
            if (i > 0) {
                int c = target.charAt(i - 1) - 'a';
                if (halfCnt[c] <= 0) break; // Cannot continue matching target prefix
                prefix[i - 1] = (char) ('a' + c);
                halfCnt[c]--;
            }

            // Case 1: Change at index i in the first half (i < m)
            if (i < m) {
                int targetChar = target.charAt(i) - 'a';
                for (int c = targetChar + 1; c < 26; c++) {
                    if (halfCnt[c] > 0) {
                        // Make candidate
                        char[] candHalf = Arrays.copyOf(prefix, m);
                        candHalf[i] = (char) ('a' + c);
                        int[] rem = halfCnt.clone();
                        rem[c]--;

                        // Fill remainder of first half with smallest available characters
                        int idx = i + 1;
                        for (int k = 0; k < 26; k++) {
                            while (rem[k] > 0) {
                                candHalf[idx++] = (char) ('a' + k);
                                rem[k]--;
                            }
                        }

                        // Construct full palindrome
                        String cand = buildPalindrome(candHalf, midChar, n);
                        if (cand.compareTo(target) > 0) {
                            if (best == null || cand.compareTo(best) < 0) {
                                best = cand;
                            }
                        }
                    }
                }
            } 
            // Case 2: Match full first half (i == m), try changing middle or checking mirrored output
            else if (i == m) {
                char[] candHalf = prefix.clone();
                String cand = buildPalindrome(candHalf, midChar, n);
                if (cand.compareTo(target) > 0) {
                    if (best == null || cand.compareTo(best) < 0) {
                        best = cand;
                    }
                }
            }
        }

        return best == null ? "" : best;
    }

    private String buildPalindrome(char[] half, int midChar, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(half);
        if (n % 2 != 0) {
            sb.append((char) ('a' + midChar));
        }
        for (int i = half.length - 1; i >= 0; i--) {
            sb.append(half[i]);
        }
        return sb.toString();
    }
}