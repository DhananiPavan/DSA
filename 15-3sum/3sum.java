class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> ans =new ArrayList<>();
        Arrays.sort(a);
        int n=a.length;
        for(int i=0;i<n;i++){
            if(i>0 && a[i]==a[i-1])continue;

            int l=i+1;
            int r=n-1;
            while(l<r){
                int sum=a[i]+a[l]+a[r];
                if(sum==0){
                    List<Integer> temp= new ArrayList<>();
                    temp.add(a[i]);
                    temp.add(a[l]);
                    temp.add(a[r]);
                    ans.add(temp);
                    l++;
                    while(l<r && a[l]==a[l-1])l++;
                    r--;
                    while(l<r && a[r]==a[r+1])r--;
                }
                if(sum<0){
                    l++;

                }
                if(sum>0){
                    r--;
                }

            }


        }
        return ans;

        
    }
}