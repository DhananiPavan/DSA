class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int start, String s, List<String> temp, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                temp.add(s.substring(start, end + 1));
                backtrack(end + 1, s, temp, ans);
                temp.remove(temp.size() - 1); // backtrack
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
