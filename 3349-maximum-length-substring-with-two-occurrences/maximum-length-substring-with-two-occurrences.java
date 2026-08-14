class Solution {
    public int maximumLengthSubstring(String str) {
         int s=0,e=0;
      int n =str.length();
      char[] nums=str.toCharArray();
      int ans=0;
      Map<Character,Integer> mp=new HashMap<>();
      while(e<n){
        mp.put(nums[e],mp.getOrDefault(nums[e],0)+1);
        
            while(mp.get(nums[e])>2){
                mp.put(nums[s],mp.get(nums[s])-1);
                if(mp.get(nums[s])==0){
                    mp.remove(nums[s]);
                }
                s++;

            }
        ans=Math.max(ans,e-s+1);
        e++;
    
        
      }  
      return ans;
    }
}