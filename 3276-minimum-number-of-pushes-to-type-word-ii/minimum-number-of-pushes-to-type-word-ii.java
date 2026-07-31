import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        // Step 1: Count frequency of each character (a-z)
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Sort frequencies in ascending order
        Arrays.sort(freq);

        int ans = 0;
        int distinctCount = 0;

        // Step 3: Iterate from highest frequency to lowest
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break; // No more characters left

            // Every 8 distinct characters, the required key presses increment by 1
            int presses = (distinctCount / 8) + 1;
            ans += freq[i] * presses;
            
            distinctCount++;
        }

        return ans;
    }
}