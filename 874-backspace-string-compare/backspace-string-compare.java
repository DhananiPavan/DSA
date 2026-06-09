class Solution {
    public boolean backspaceCompare(String s, String t) {
      Stack<Character> stack=new Stack<>();
      for(Character ch :s.toCharArray()){
        if(!stack.isEmpty() &&ch=='#'){
            stack.pop();
        }
        else if(ch=='#'){
            continue;
        }
        else {
            stack.push(ch);
        }
      }  
      StringBuilder ans=new StringBuilder();
      while(!stack.isEmpty()){
        ans.insert(0,stack.pop());
      }
      for(Character ch :t.toCharArray()){
        if(!stack.isEmpty() &&ch=='#'){
            stack.pop();
        }
         else if(ch=='#'){
            continue;
        }
        else{
            stack.push(ch);
        }
      }  
      StringBuilder ans2=new StringBuilder();
      while(!stack.isEmpty()){
        ans2.insert(0,stack.pop());
      }
      return ans.compareTo(ans2) == 0;
    }
}