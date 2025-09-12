class Solution {
    public int minEatingSpeed(int[] p, int h) {
       
        int low=1;
        int  high =  findMax(p);

        while (low <= high) {
            int mid = (low + high) / 2;
            long totalH = calculateTotalHours(p, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
           return low;


        
    }
  long  calculateTotalHours(int[] p,int mid){
    long t=0;
    for(int i=0;i<p.length;i++){
        t += (p[i] + mid - 1) / mid;
    }
    return t;


  }
  public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }
  




}