class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum possible open parentheses needed
        int maxOpen = 0; // Maximum possible open parentheses allowed

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else if (c == '*') {
                minOpen--; // Treat '*' as ')'
                maxOpen++; // Treat '*' as '('
            }

            // We have more ')' than '(' and '*' combined, invalid string
            if (maxOpen < 0) {
                return false;
            }

            // minOpen cannot be negative since we can't have negative open brackets
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        // String is valid if we can balance all open parentheses
        return minOpen == 0;
    }
}