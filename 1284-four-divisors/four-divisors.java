class Solution {
    public int sumFourDivisors(int[] nums) {
       int ans =0;
       for(int x:nums){
        ans+=add(x);
       }   
     return ans;
    }
    public int add(int val){
        int n=val;
        int count=0;
        int sum =0;
        for(int i =1;i*i<=n;i++){
            if(n%i==0){
                sum+=i;
                count++;
                if(n/i!=i && n%(n/i)==0){
                    count++;
                    sum+=n/i;
                }
            }
        }
        return count==4?sum:0;
    }
}