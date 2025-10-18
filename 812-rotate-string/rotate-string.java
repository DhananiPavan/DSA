class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths are different, rotation is impossible
        if (s.length() != goal.length()) return false;

        // Concatenate s with itself
        String combined = s+s;

        // Check if goal is a substring of combined
        return combined.contains(goal);
    }
}