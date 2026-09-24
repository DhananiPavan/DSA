class Solution {
    public boolean isThree(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count +=1;
                if(n/i !=i && n%(n/i)==0)count+=1;
            }
            
        }

        return count==3?true:false;
    }
}