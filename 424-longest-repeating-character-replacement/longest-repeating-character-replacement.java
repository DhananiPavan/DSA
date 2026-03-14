import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int r = 0; r < s.length(); r++) {

            char ch = s.charAt(r);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            while ((r - l + 1) - maxFreq > k) {

                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}