import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map row number to a bitmask representing reserved seats (2-9)
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            // Only care about seats 2 through 9
            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << col));
            }
        }

        // Default: every row can fit 2 families
        int maxFamilies = (n - map.size()) * 2;

        // Masks for seats [2,3,4,5], [4,5,6,7], [6,7,8,9]
        int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);   // seats 2, 3, 4, 5
        int mid  = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);   // seats 4, 5, 6, 7
        int right= (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);   // seats 6, 7, 8, 9

        for (int mask : map.values()) {
            boolean canLeft = (mask & left) == 0;
            boolean canRight = (mask & right) == 0;

            if (canLeft && canRight) {
                maxFamilies += 2;
            } else if (canLeft || canRight || (mask & mid) == 0) {
                maxFamilies += 1;
            }
        }

        return maxFamilies;
    }
}