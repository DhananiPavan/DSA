class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return n;
        }
        //    looking for the code—they're looking for the proof. The proof relies on properties of XOR over the set {1, 2, ..., n} and showing that for n ≥ 3, all 2^k values (where k is the bit length of n) are achievable. That's the key insight behind this problem.
        int bits = 32 - Integer.numberOfLeadingZeros(n);
        return 1 << bits;
    }
}