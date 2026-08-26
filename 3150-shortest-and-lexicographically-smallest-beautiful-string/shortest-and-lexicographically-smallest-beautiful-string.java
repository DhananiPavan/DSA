class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int count = 0;
        int left = 0;
        String result = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                count++;
            }

            // Shrink window from the left if count reaches k
            while (count == k) {
                // Remove leading zeros to make the substring as short as possible
                while (s.charAt(left) == '0') {
                    left++;
                }

                String current = s.substring(left, right + 1);

                // Update result if it's shorter or lexicographically smaller
                if (result.isEmpty() || current.length() < result.length() ||
                   (current.length() == result.length() && current.compareTo(result) < 0)) {
                    result = current;
                }

                // Move left pointer past the first '1' to search for next potential string
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }
        }

        return result;
    }
}