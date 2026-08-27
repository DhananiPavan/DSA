class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {

            int cur = target.charAt(i) - 'a';

            // We can match target[i]
            if (freq[cur] > 0) {
                freq[cur]--;
                ans.append(target.charAt(i));
            } 
            else {

                // Cannot match target[i].
                // Find the smallest character greater than target[i].
                for (int j = cur + 1; j < 26; j++) {

                    if (freq[j] > 0) {
                        ans.append((char) ('a' + j));
                        freq[j]--;

                        // Fill remaining characters in sorted order
                        for (int k = 0; k < 26; k++) {
                            while (freq[k] > 0) {
                                ans.append((char) ('a' + k));
                                freq[k]--;
                            }
                        }

                        return ans.toString();
                    }
                }

                // No greater character here.
                // Backtrack to an earlier position.
                break;
            }
        }

        /*
         * Backtracking:
         * Try changing the rightmost character of the
         * matched prefix to something greater.
         */
        while (ans.length() > 0) {

            int pos = ans.length() - 1;

            // Put the previously used character back
            int last = ans.charAt(pos) - 'a';
            freq[last]++;
            ans.deleteCharAt(pos);

            int targetChar = target.charAt(pos) - 'a';

            // Find smallest character > target[pos]
            for (int j = targetChar + 1; j < 26; j++) {

                if (freq[j] > 0) {

                    ans.append((char) ('a' + j));
                    freq[j]--;

                    // Fill remaining characters smallest first
                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}