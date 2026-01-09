class Solution {
    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long result = (power(5, evenPositions) * power(4, oddPositions)) % MOD;
        return (int) result;
    }

    private long power(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1)//check the number is odd or not by using bits 
             {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;//exp=exp/2;
        }

        return result;
    }
}
