class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // frequency of p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            // add current character
            sCount[s.charAt(right) - 'a']++;

            // maintain window size
            if (right - left + 1 > p.length()) {

                sCount[s.charAt(left) - 'a']--;
                left++;
            }

            // compare arrays
            if (Arrays.equals(pCount, sCount)) {
                ans.add(left);
            }
        }

        return ans;
    }
}