class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;

        String[] map = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(0, digits, map, "", ans);
        return ans;
    }

    void backtrack(int index, String digits, String[] map,
                   String temp, List<String> ans) {

        if (index == digits.length()) {
            ans.add(temp);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            backtrack(index + 1, digits, map,
                      temp + letters.charAt(i), ans);
        }
    }
}
