class Solution {
    public String smallestPalindrome(String s) {

        char m = '\0';
        int l = s.length();
        if (l <= 2) {
            return s;
        }
        if (l % 2 != 0) {
            m = s.charAt((l / 2));
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            i++;
            if (i <= (l / 2)) {
                ans.append(c);
            } else {
                break;
            }

        }
        char[] chars = ans.toString().toCharArray();
        Arrays.sort(chars);

        // 2. Build the first half
        StringBuilder half = new StringBuilder(new String(chars));

        // 3. Construct the result
        StringBuilder finalans = new StringBuilder();
        finalans.append(half);

        if (m != '\0') {
            finalans.append(m);
        }

        // Append the reversed first half to complete the palindrome
        finalans.append(new StringBuilder(half).reverse());

        return finalans.toString();

    }
}