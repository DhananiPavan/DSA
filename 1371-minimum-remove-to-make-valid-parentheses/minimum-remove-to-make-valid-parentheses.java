class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        int open =0;
        for(char c :s.toCharArray()){
            if(c=='('){
                open++;
                stack.push(c);
            }
            else if(c==')'){
                if(open>0){
                    stack.push(c);
                    open--;
                }
            }
            else{
                stack.push(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c :stack){
            sb.append(c);
        }
        if(open>0){
            for(int i=sb.length()-1;i>=0 && open>0;i--){
                if(sb.charAt(i)=='('){
                    sb.deleteCharAt(i);
                    open--;
                }
            }
        }
        return sb.toString();
    }
}