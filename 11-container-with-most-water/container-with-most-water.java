class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int ans=0;
        while(l<r){
            int w=r-l;
            int h=Math.min(height[l],height[r]);
            ans=Math.max(ans,w*h);
            if(height[l]<height[r]){
              while(l<r && height[l]<=h)l++;//use while loop to skip lesser height compare 
                                            //previous min height 'h';
             }
            else{
                while(l<r && height[r]<=h)r--;
            }
        }
        return ans;
    }
}