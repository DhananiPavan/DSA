class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        int n=heights.length;
        for(int i=0;i<=n;i++){
            int cur=(i==n)?0:heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>cur){
                int h=heights[stack.pop()];
                int w=(stack.isEmpty())?i:i-stack.peek()-1;
                max=Math.max(max,h*w);
            }
            stack.push(i);
        }
        return max;
        
    }
}