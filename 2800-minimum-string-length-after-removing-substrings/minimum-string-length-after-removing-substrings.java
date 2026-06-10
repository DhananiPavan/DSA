class Solution {
    public int minLength(String s) {
       Stack<Character> stack =new Stack<>();
       for(Character c : s.toCharArray()){
          if(!stack.isEmpty()){
            char top=stack.peek();
            if((top=='A' && c=='B') ||(top=='C' && c=='D')){
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
       return stack.size();
    }
}