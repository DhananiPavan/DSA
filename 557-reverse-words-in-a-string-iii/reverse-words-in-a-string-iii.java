class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;

        for (int end = 0; end <= chars.length; end++) {
            // Reached space or end of string -> reverse current word
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1; // Move start pointer to next word
            }
        }

        return new String(chars);
    }

    // Two-pointer swap directly on char array
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}