import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> mpp = new HashMap<>();
        int l = 0;
        int ans = 0;

        for (int r = 0; r < fruits.length; r++) {

            mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);

            while (mpp.size() > 2) {

                mpp.put(fruits[l], mpp.get(fruits[l]) - 1);

                if (mpp.get(fruits[l]) == 0) {
                    mpp.remove(fruits[l]);
                }

                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}