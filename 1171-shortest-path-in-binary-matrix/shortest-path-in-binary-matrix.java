class Solution {
    class Node {
        int first;

        int second;
        int value;

        Node(int first, int second,int value) {
            this.first = first;
            this.second = second;
            this.value=value;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
       int m = grid.length;
       int n= grid[0].length;
       int ans=Integer.MAX_VALUE;
       if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {
            return -1;
        }

        if (m == 1 && n == 1) {
            return 1;
        }
       Queue<Node> q=new LinkedList<>();
       q.offer(new Node(0,0,1));
        grid[0][0]=1;
       int[][] dirs={{1, 1}, {1, 0}, {0, 1}, {1, -1},
                {-1, 1}, {-1, 0}, {0, -1}, {-1, -1}};
       while(!q.isEmpty()){
        Node cur= q.poll();
        int x= cur.first;
        int y=cur.second;
        int val=cur.value;
       
        for(int[] dir:dirs){
           int nx=x+dir[0];
           int ny=y+dir[1];
           if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0){
            if (nx == m - 1 && ny == n - 1) {
                        return val + 1;
                    }
            grid[nx][ny]=1;
            q.offer(new Node(nx,ny,val+1));
            

           }
           
        }
          
       }
       return -1;

    }

}