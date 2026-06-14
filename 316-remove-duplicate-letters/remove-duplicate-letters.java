class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last =new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;

        }
        Stack<Character> stack=new Stack<>();
        boolean[] visited=new boolean[26];
        int i=0;
        for(char c: s.toCharArray()){
            if(visited[c-'a']==true){
                i++;
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>c && last[stack.peek()-'a']>i){
             visited[stack.pop()-'a']=false;;
             
            }
            stack.push(c);
            visited[c-'a']=true;
            i++;
        }
        StringBuilder sb=new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }



        return sb.toString();
        
    }
}