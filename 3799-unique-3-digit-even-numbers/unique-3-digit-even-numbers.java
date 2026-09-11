class Solution {
    public int totalNumbers(int[] digits) {
        // Count frequency of each digit in the input array
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        int total = 0;

        // Iterate through all 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            int d1 = num / 100;       // hundreds digit
            int d2 = (num / 10) % 10; // tens digit
            int d3 = num % 10;        // ones digit

            // Count required digits for the current number
            int[] req = new int[10];
            req[d1]++;
            req[d2]++;
            req[d3]++;

            // Check if available digits are sufficient
            if (count[d1] >= req[d1] && count[d2] >= req[d2] && count[d3] >= req[d3]) {
                total++;
            }
        }

        return total;
    }
}