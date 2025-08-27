class Solution {
    public List<List<Integer>> fourSum(int[] n, int target) {
        List<List<Integer>> ans =new ArrayList();
        Arrays.sort(n);
        for(int i=0;i<n.length;i++){
            if(i>0 && n[i]==n[i-1]){
                continue;
            }
            for(int j=i+1;j<n.length;j++){
                if(j>i+1 && n[j]==n[j-1]){
                    continue;
                }
                int k=j+1;
                int l=n.length-1;
                while(k<l){
                     long sum =(long)n[i]+ (long)n[j]+ (long)n[k]+ (long)n[l];
                     if(sum==target){
                        List<Integer> t=Arrays.asList(n[i], n[j], n[k],n[l]);
                        ans.add(t);
                        k++;
                        l--;
                        while(  k<l && n[k]==n[k-1]  ){
                            k++;
                        }
                         while(  k<l && n[l]==n[l+1] ){
                            l--;
                        }


                     }
                     else if(sum<target){
                        k++;

                     }
                     else{
                        l--;
                     }
                





                    }
            }
        } 
        return ans;      
    }
}