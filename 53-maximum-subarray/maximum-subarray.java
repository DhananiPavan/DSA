class Solution {
    public int maxSubArray(int[] a) {
     int max=Integer.MIN_VALUE;
     int sum=0;
     for(int i=0;i<a.length;i++){
        sum=sum+a[i];//add every element
        max=Math.max(max,sum);//check max
        sum=(sum<0)?0:sum;// if negative  sum occur make it 0
        
     } 
     return max;  
    }
}