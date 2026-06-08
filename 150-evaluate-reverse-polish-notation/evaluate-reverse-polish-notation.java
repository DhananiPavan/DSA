class Solution {
    public int evalRPN(String[] tokens) {
        // A primitive array acts as our high-performance stack
        int[] stack = new int[tokens.length];
        int top = 0; // Pointer to track the top of the stack
        
        for (String s : tokens) {
            // If the token is longer than 1 character, it MUST be a number (e.g., "11", "-11")
            // If it is 1 character long, check if it's a digit or an operator
            char c = s.charAt(0);
            
            if (s.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                // Pop the top two elements out of our primitive stack
                int b = stack[--top];
                int a = stack[--top];
                
                switch (c) {
                    case '+': stack[top++] = a + b; break;
                    case '-': stack[top++] = a - b; break;
                    case '*': stack[top++] = a * b; break;
                    case '/': stack[top++] = a / b; break;
                }
            } else {
                // It's a number, parse it and push it directly as a primitive int
                stack[top++] = Integer.parseInt(s);
            }
        }
        
        // The last remaining element is our final answer
        return stack[0];
    }
}