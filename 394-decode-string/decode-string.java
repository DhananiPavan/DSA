class Solution {
    public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Form the multi-digit number
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the complete number and the bracket onto the stack
                stack.push(num);
                stack.push("[");
                num = 0; // Reset number for the next potential nested block
            } else if (ch == ']') {
                // 1. Pop all strings until we hit the opening bracket '['
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                
                // Pop the opening bracket '['
                stack.pop();
                
                // 2. The next element on the stack is guaranteed to be the repeat count (Integer)
                int repeatCount = (Integer) stack.pop();
                
                // 3. Repeat the string block
                StringBuilder repeatedString = new StringBuilder();
                for (int i = 0; i < repeatCount; i++) {
                    repeatedString.append(sb);
                }
                
                // Push the newly formed string back onto the stack
                stack.push(repeatedString.toString());
            } else {
                // Push normal characters as strings
                stack.push(String.valueOf(ch));
            }
        }

        // Combine whatever is left in the stack into the final result
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}