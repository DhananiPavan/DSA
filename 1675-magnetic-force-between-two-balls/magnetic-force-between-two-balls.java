class Solution {
    public int maxDistance(int[] position, int m) {
      Arrays.sort(position);
      int l=1;
      int r=position[position.length-1]-position[0];
      int ans=0;
      while(l<=r){
        int mid=l+(r-l)/2;
        if(calm(position,m,mid)){
            ans=mid;
            l=mid+1;
        }
        else{
            r=mid-1;
        }
      }  
      return ans;
        
    }
    boolean calm(int[] arr,int m,int mid){
        int balls=1;
        int last=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-last>=mid){
                balls++;
                last=arr[i];
            }
        }
        return balls >=m;
    }
}