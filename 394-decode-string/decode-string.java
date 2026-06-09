class Solution {
    public String decodeString(String strings) {
        Stack<Object> stack=new Stack<>();
        int num=0;
        StringBuilder sb=new StringBuilder();
        for(Character c:strings.toCharArray()){
            if(Character.isDigit(c)){
             num=num*10+(c-'0');
            }
            else if(c=='['){
                stack.push(num);
                stack.push('[');
                num=0;
            }
            else if(c==']'){
              StringBuilder s=new StringBuilder();
              while(!stack.isEmpty() && !stack.peek().equals('[')){
                s.insert(0,stack.pop());
              }    
              stack.pop();
              int repeat=(Integer) stack.pop();
              sb=new StringBuilder();
              for(int i=0;i<repeat;i++){
                sb.append(s);
              }
              stack.push(sb.toString());
              

            }
            else{
                stack.push(String.valueOf(c));
            }
            

        }
        sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();

    }
}