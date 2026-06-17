class Solution {
    public boolean isHappy(int n) {
        // Base cases for single digits
        if (n == 1 || n == 7) {
            return true;
        }
        if (n < 10) {
            return false;
        }
        
        int sum = 0;
        int x = n;
        
        // Corrected loop to process all digits
        while (x != 0) {
            int b = x % 10;
            sum += b * b; // Accumulate the sum of squares
            x = x / 10;   // Divide by 10 to move to the next digit
        }
        
        // Recursively call with the new sum
        return isHappy(sum);
    }
}