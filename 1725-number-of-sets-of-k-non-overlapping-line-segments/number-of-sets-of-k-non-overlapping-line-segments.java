class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1000000007;
        long N = n + k - 1;
        long K = 2 * k;
        
        long ans = 1;
        for (int i = 1; i <= K; i++) {
            ans = (ans * (N - i + 1)) % MOD;
            ans = (ans * modInverse(i, MOD)) % MOD;
        }
        return (int) ans;
    }
    
    private long modInverse(long a, long m) {
        return power(a, m - 2, m);
    }
    
    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}