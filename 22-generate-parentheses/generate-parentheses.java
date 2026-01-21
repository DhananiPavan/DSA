class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String curr, int open, int close, int n) {
        // If the current string is complete
        if (curr.length() == 2 * n) {
            result.add(curr);
            return;
        }

        // Add opening bracket if possible
        if (open < n) {
            backtrack(result, curr + "(", open + 1, close, n);
        }

        // Add closing bracket if valid
        if (close < open) {
            backtrack(result, curr + ")", open, close + 1, n);
        }
    }
}






