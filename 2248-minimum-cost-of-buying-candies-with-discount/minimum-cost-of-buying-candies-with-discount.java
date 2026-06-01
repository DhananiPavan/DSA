

class Solution {
    public int minimumCost(int[] cost) {
        // Sort the costs in ascending order
        Arrays.sort(cost);
        
        int totalCost = 0;
        int n = cost.length;
        
        // Traverse backwards from the most expensive candy
        // We maintain a counter to keep track of when to skip a candy
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            count++;
            if (count % 3 == 0) {
                // This is the 3rd candy, it's free!
                continue;
            }
            totalCost += cost[i];
        }
        
        return totalCost;
    }
}