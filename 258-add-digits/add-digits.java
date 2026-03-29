class Solution {
    public int addDigits(int num) {
        
if (num == 0) return 0;
        return 1 + (num - 1) % 9;
    }
}


// dr(n)=1+(n−1)mod9;

// dr(11) = 1 + (11 - 1) % 9
//        = 1 + 10 % 9
//        = 1 + 1
//        = 2