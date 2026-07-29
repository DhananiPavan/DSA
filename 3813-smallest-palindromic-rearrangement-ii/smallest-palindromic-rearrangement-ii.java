










class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char mid = '\0';
        int halfLen = 0;
        int[] count = new int[26];
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                mid = (char) ('a' + i);
            }
            count[i] = freq[i] / 2;
            halfLen += count[i];
        }

        StringBuilder half = new StringBuilder();

        for (int p = 0; p < halfLen; p++) {
            boolean found = false;
            for (int i = 0; i < 26; i++) {
                if (count[i] == 0) continue;

                count[i]--;
                long ways = countPermutations(count, k);

                if (ways >= k) {
                    half.append((char) ('a' + i));
                    found = true;
                    break;
                } else {
                    k -= ways;
                    count[i]++; // Backtrack
                }
            }
            if (!found) return "";
        }

        StringBuilder result = new StringBuilder(half);
        if (mid != '\0') {
            result.append(mid);
        }
        result.append(new StringBuilder(half).reverse());

        return result.toString();
    }

    // Computes M! / (c1! * c2! * ... * c26!) capped at maxK + 1
    private long countPermutations(int[] count, long maxK) {
        long total = 1;
        int rem = 0;
        for (int c : count) rem += c;

        for (int c : count) {
            if (c > 0) {
                total = total * nCr(rem, c, maxK);
                rem -= c;
                if (total > maxK) return maxK + 1;
            }
        }
        return total;
    }

    private long nCr(int n, int r, long maxK) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (r > n - r) r = n - r;

        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
            if (res > maxK) return maxK + 1;
        }
        return res;
    }
}






// class Solution {
//     public String smallestPalindrome(String s, int k) {
//         StringBuilder ans = new StringBuilder();
//         int l = s.length();
//         char m = '\0';
//         if (l % 2 != 0) {
//             m = s.charAt(l / 2);
//         }
//         int[] f = new int[26];
//         for (char c : s.toCharArray()) {
//             f[c - 'a']++;
//         }
//         StringBuilder half = new StringBuilder();
//         char not = '\0';
//         for (int i = 0; i < 26; i++) {
//             if (f[i] != 0 && f[i] % 2 == 0) {
//                 k--;
//             }
//             if (k == 0) {
//                 for (int j = 0; j < f[i] / 2; j++) {
//                     half.append((char) (i + 'a'));
//                     not = (char) (i + 'a');
//                 }
//             }
//         }
//         if (k == 0) {
//             for (int i = 0; i < 26; i++) {

//                 if (not != (char) i + 'a') {
//                     for (int j = 0; j < f[i] / 2; j++) {
//                         half.append((char) (i + 'a'));
//                        not = (char) (i + 'a');
//                     }
//                 }
//             }
//             ans.append(half);
//             if (m != '\0')
//                 ans.append(m);

//             ans.append(new StringBuilder(half).reverse());

//         }
//         return ans.toString();

//     }
// }