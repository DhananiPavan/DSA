class Solution {
    public static int maxProduct(int[] arr) {
       int p=1,s=1;
       int max=Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++){
        if(p==0)p=1;
        if(s==0)s=1;
        p=p*arr[i];
        s=s*arr[arr.length-1-i];
        max=Math.max(max,Math.max(p,s));
       }


       return max;
    }
}