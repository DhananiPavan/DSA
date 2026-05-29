class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
      int l=1;
      int r= (int)1e7;
      int ans=-1;
      while(l<=r){
        int mid= l+(r-l)/2;
        if(calt(dist,hour,mid)){
            ans=mid;
            r=mid-1;
        }
        else{
            l=mid+1;
        }

      } 
      return ans; 
    }
    boolean calt(int[] dis,double h,int speed){
        double time=0.0;
        for(int i=0;i<dis.length;i++){
            double t =(double)dis[i]/speed;
            if(i!=dis.length-1){
                time+=Math.ceil(t);
            }
            else{
                time+=t;
            }
        }
        return time<=h;
    }
}