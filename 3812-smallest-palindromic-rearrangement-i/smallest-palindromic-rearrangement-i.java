class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int halfLen = n / 2;

        // 1. Extract the first half of characters
        char[] half = s.substring(0, halfLen).toCharArray();
        
        // 2. Sort them to get the lexicographically smallest arrangement
        Arrays.sort(half);
        
        String firstHalf = new String(half);
        StringBuilder sb = new StringBuilder(firstHalf);

        // 3. If odd length, append the original middle character
        if (n % 2 != 0) {
            sb.append(s.charAt(halfLen));
        }

        // 4. Mirror the first half
        sb.append(new StringBuilder(firstHalf).reverse());

        return sb.toString();
    }
}