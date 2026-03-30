class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
          List<Integer> ans = new ArrayList<>();
          while(left<=right){
             if (isSelfDividing(left)) {
                ans.add(left);
            }
            left++;
          }
          return ans;
    }

    private boolean isSelfDividing(int num) {
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;

            if (digit == 0 || num % digit != 0) {
                return false;
            }

            temp /= 10;
        }

        return true;
    }   
    
 
}



   
