class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack =new Stack<>();
        for(Character c: s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()==c){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0,stack.pop());
        }
        return ans.toString();
    }
}