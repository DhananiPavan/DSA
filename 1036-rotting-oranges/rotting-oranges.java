class Solution {
    class Node {
        int first;

        int second;

        Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int o = 0;
        int seconds = 0;
        // Add all the totten oranges to Queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Node(i, j));
                }
                if (grid[i][j] == 1) {
                    o++;

                }
            }
        }

        //take possible directions
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty() && o > 0) {
            int s = q.size();
            seconds++;
            for (int i = 0; i < s; i++) {
                Node cur = q.poll();
                int x = cur.first;
                int y = cur.second;
                for (int[] dir : dirs) {

                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        q.offer(new Node(nx, ny));
                        o--;
                    }
                }

            }
        }
       return o == 0 ? seconds : -1;
    }
}