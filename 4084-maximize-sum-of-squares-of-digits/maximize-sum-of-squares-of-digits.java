class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if ((long) num * 9 < sum || sum < 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int currentSum = sum;
        
        for (int i = 0; i < num; i++) {
            int remainingSlots = num - 1 - i;
            // Find the largest digit for the current position such that 
            // the remaining sum can still be formed by the remaining slots.
            int minNeeded = Math.max(0, currentSum - remainingSlots * 9);
            int maxPossible = Math.min(9, currentSum);
            
            // To maximize the number, we want the largest possible digit for the current position.
            // So we start testing from maxPossible down to minNeeded.
            // Since we want the largest number, we pick maxPossible, 
            // provided it leaves a valid sum for the rest.
            int chosenDigit = -1;
            for (int d = maxPossible; d >= minNeeded; d--) {
                // Check if this digit leaves a valid remaining sum that can be formed
                if (currentSum - d <= remainingSlots * 9) {
                    chosenDigit = d;
                    break;
                }
            }
            
            if (chosenDigit == -1) {
                return "";
            }
            
            sb.append(chosenDigit);
            currentSum -= chosenDigit;
        }
        
        return sb.toString();
    }
}