class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // count s1 characters
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int k = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            // add current char to window
            windowCount[s2.charAt(i) - 'a']++;

            // remove char if window size exceeds
            if (i >= k) {
                windowCount[s2.charAt(i - k) - 'a']--;
            }

            // compare arrays
            if (matches(s1Count, windowCount)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}