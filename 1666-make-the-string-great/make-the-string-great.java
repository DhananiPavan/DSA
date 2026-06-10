class Solution {
    public String makeGood(String s) {
        Stack<Character> stack =new Stack<>();
        for(Character c:s.toCharArray()){
            if(!stack.isEmpty() && Character.toLowerCase(c)==Character.toLowerCase(stack.peek())){
                if(c!=stack.peek()){
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
        StringBuilder ans=new StringBuilder();
        for(Character c:stack){
            ans.append(c);
        }
        return ans.toString();
    }
}