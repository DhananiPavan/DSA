import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == -1) {
                first[ch] = i;
            }
            last[ch] = i;
        }

        List<String> result = new ArrayList<>();
        int rightBound = -1;

        for (int i = 0; i < n; i++) {
            // Only start checking when 'i' is the first occurrence of a character
            if (i == first[s.charAt(i) - 'a']) {
                int newRight = getValidRightBound(s, i, first, last);
                if (newRight != -1) {
                    // If the current valid range is completely before or inside the previous range, update
                    if (i > rightBound) {
                        result.add("");
                    }
                    rightBound = newRight;
                    result.set(result.size() - 1, s.substring(i, rightBound + 1));
                }
            }
        }

        return result;
    }

    private int getValidRightBound(String s, int start, int[] first, int[] last) {
        int right = last[s.charAt(start) - 'a'];
        for (int i = start; i <= right; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] < start) {
                return -1; // Contains a character that started before our 'start'
            }
            right = Math.max(right, last[ch]);
        }
        return right;
    }
}