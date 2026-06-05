class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int max=0;
        int[] height=new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
             
             if(matrix[i][j]=='1'){
                height[j]+=1;
             }
             else{
                height[j]=0;
             }
            }
            max=Math.max(max,calarea(height));
        }
      return max;  
        
    }
    private int calarea(int[] h){
        Stack<Integer> s=new Stack<>();
        int max=0;
        int n=h.length;
        for(int i=0;i<=n;i++){
           int val=(i==n)?0:h[i]; 
          while(!s.isEmpty()&& h[s.peek()]>val){
           int height=h[s.pop()];
           int w=(s.isEmpty())?i:i-s.peek()-1;
           max=Math.max(max,height*w);
          }
          s.push(i);
        }
        return max;
    }
}