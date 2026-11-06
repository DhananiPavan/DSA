import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        
        // Step 1: Store queries with their original indices so we can restore the order
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
        // Sort queries by their time values
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 2: Sort logs by time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[] ans = new int[m];
        int[] serverCount = new int[n + 1]; // Tracks request frequency for each server
        int activeServers = 0; // Number of servers that have at least 1 request in the window
        
        int left = 0;
        int right = 0;
        int logLen = logs.length;
        
        // Step 3: Process each query using a sliding window over logs
        for (int i = 0; i < m; i++) {
            int qTime = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            
            int windowStart = qTime - x;
            int windowEnd = qTime;
            
            // Expand window right boundary to include logs <= windowEnd
            while (right < logLen && logs[right][1] <= windowEnd) {
                int sId = logs[right][0];
                if (serverCount[sId] == 0) {
                    activeServers++;
                }
                serverCount[sId]++;
                right++;
            }
            
            // Shrink window left boundary to remove logs < windowStart
            while (left < right && logs[left][1] < windowStart) {
                int sId = logs[left][0];
                serverCount[sId]--;
                if (serverCount[sId] == 0) {
                    activeServers--;
                }
                left++;
            }
            
            // Total servers minus servers with requests = zero-request servers
            ans[originalIndex] = n - activeServers;
        }
        
        return ans;
    }
}