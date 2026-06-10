class Solution {
    public int minAddToMakeValid(String s) {

       int open =0;
       int close=0;//move 
       for(Character c:s.toCharArray()){
        if(c=='('){
            open++;
        }
        else{
            if(open>0)open--;
            else{
                close++;
            }
        }
       
       }
       return open+close; 
    }
}
//if valid open and close found open will be 0 
//other wise invalid open open++
//invalid close close++;