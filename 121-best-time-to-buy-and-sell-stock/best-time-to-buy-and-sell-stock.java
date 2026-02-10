class Solution {
    public int maxProfit(int[] a) {
        int min=a[0],max=0;
        for(int i=1;i<a.length;i++){
            if(min>a[i]){
                min=a[i];
            }
            else if(a[i]-min>max){
                max=a[i]-min;

            }
        }
        return max;
        
    }
}