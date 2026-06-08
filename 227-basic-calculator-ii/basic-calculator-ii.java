class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int num=0;
        char op='+';
        for(int i=0;i<=s.length();i++){
            char ch=(i==s.length())?0:s.charAt(i);
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if(ch!=' '){
                // if(op=='+'){
                //     stack.push(num);
                // }
                // if(op=='-'){
                //     stack.push(-num);
                // }
                // if(op=='*'){
                //     stack.push(stack.pop()*num);
                // }
                // if(op=='/'){
                //     stack.push(stack.pop()/num);
                // }
                switch(op){
                    case '+':
                             stack.push(num);
                             break;
                    case '-':
                             stack.push(-num);
                             break;
                    case '*':
                             stack.push(stack.pop()*num);
                             break;
                    case '/':
                             stack.push(stack.pop()/num);
                             break;

                }
                num=0;
                op=ch;
                
                
            }
        }
        int ans=0;
        while(!stack.isEmpty()) ans+=stack.pop();
        return ans;
    }
}