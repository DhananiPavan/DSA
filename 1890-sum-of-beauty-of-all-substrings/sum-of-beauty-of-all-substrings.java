class Solution {
    public int beautySum(String s) {
          int n = s.length();
        int totalBeauty = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; // frequency of characters
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0, minFreq = Integer.MAX_VALUE;

                // find max and min frequencies among characters that appear
                for (int f : freq) {
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }
                totalBeauty += (maxFreq - minFreq);
            }
        }
        return totalBeauty;
    }
}