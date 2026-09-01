import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startX = -1, startY = -1;
        List<int[]> litterList = new ArrayList<>();
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startX = r;
                    startY = c;
                } else if (ch == 'L') {
                    litterList.add(new int[]{r, c});
                }
            }
        }
        
        int totalLitter = litterList.size();
        if (totalLitter == 0) {
            return 0;
        }
        
        int targetMask = (1 << totalLitter) - 1;
        
        // distMap[r][c][mask] stores the maximum remaining energy achieved at (r, c) with collected mask
        int[][][] maxEnergy = new int[m][n][1 << totalLitter];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }
        
        // Queue for BFS: [r, c, mask, currentEnergy]
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{startX, startY, 0, energy});
        maxEnergy[startX][startY][0] = energy;
        
        int steps = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int e = curr[3];
                
                if (mask == targetMask) {
                    return steps;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nr = r + dirs[d];
                    int nc = c + dirs[d + 1];
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        char tile = classroom[nr].charAt(nc);
                        if (tile == 'X') continue;
                        
                        int nextE = e - 1;
                        if (nextE < 0) continue;
                        
                        int nextMask = mask;
                        
                        if (tile == 'R') {
                            nextE = energy;
                        } else if (tile == 'L') {
                            for (int k = 0; k < totalLitter; k++) {
                                if (litterList.get(k)[0] == nr && litterList.get(k)[1] == nc) {
                                    nextMask |= (1 << k);
                                    break;
                                }
                            }
                        }
                        
                        // Prune state if we've reached (nr, nc) with nextMask having equal or more energy
                        if (nextE > maxEnergy[nr][nc][nextMask]) {
                            maxEnergy[nr][nc][nextMask] = nextE;
                            queue.offer(new int[]{nr, nc, nextMask, nextE});
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}