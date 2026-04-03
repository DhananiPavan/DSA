class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        
        while (columnNumber > 0) {
            // Shift to 0-indexed
            columnNumber--; 
            
            // Get the current character (A = 65 in ASCII)
            char c = (char) ('A' + (columnNumber % 26));
            sb.append(c);
            
            // Move to the next "digit"
            columnNumber /= 26;
        }
        
        // Since we appended from right to left, reverse the string
        return sb.reverse().toString();
    }
}