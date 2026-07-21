class Solution {
    public String reverseWords(String s) {
       StringBuilder ans= new StringBuilder();
       StringBuilder word =new StringBuilder();
       
      for(char c : s.toCharArray()){
        if(c==' '){
            ans.append(reverse(word));
            ans.append(c);
            word.setLength(0);
        }
        else{
            word.append(c);
        }
      }
      ans.append(reverse(word));
      return ans.toString();
      
     
    }
    // public String reverse(StringBuilder word) {
    //     return word.reverse().toString();
    // }
    private String reverse(StringBuilder word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            char temp = word.charAt(left);
            word.setCharAt(left, word.charAt(right));
            word.setCharAt(right, temp);
            left++;
            right--;
        }

        return word.toString();
    }

}