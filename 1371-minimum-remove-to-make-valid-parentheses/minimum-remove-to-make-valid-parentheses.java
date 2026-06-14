class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> st = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '(') {
                st.push(i);
            }

            else if (arr[i] == ')') {

                if (!st.isEmpty()) {
                    st.pop();   // matched
                } else {
                    arr[i] = '#';   // mark invalid ')'
                }
            }
        }

        // remaining '(' are invalid
        while (!st.isEmpty()) {
            arr[st.pop()] = '#';
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : arr) {
            if (ch != '#') {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}