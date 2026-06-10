class Solution {
    public boolean isValid(String s) {
       Stack<Character> stack=new Stack<>();
       for(Character c :s.toCharArray()){
        if(!stack.isEmpty()){
            char top=stack.peek();
            if((top=='(' && c==')') ||(top=='{' && c=='}')||(top=='[' && c==']')){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        else{
            stack.push(c);
        }

       } 
       return stack.size()<1;
    }
}