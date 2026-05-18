class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {
            // Move the left pointer if the character is not alphanumeric
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } 
            // Move the right pointer if the character is not alphanumeric
            else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } 
            // If both are alphanumeric, compare them case-insensitively
            else {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        
        return true;
    }
}