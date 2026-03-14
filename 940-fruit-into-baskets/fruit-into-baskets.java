class Solution {
    public int totalFruit(int[] fruits) {
    Map<Integer, Integer> mpp = new HashMap<>();
    int l=0;
    int ans=0;
    int total=0;
    for(int r=0;r<fruits.length;r++){
      mpp.put(fruits[r],mpp.getOrDefault(fruits[r], 0)+1);
      total+=1;
      while(mpp.size()>2){
        mpp.put(fruits[l],mpp.get(fruits[l])-1);
        total-=1;
        
        if(mpp.get(fruits[l])==0){
        mpp.remove(fruits[l]);
      }
      l++;
      }
      
      ans=Math.max(ans,total);

     
    } 
    return ans; 
    }
}