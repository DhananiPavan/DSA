class Solution {
    class Node {
        int first;

        int second;

        Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m =image.length;
        int n =image[0].length;
       Queue<Node> q = new LinkedList<>();
        
        if(image[sr][sc]==color){
            return image;
        }
        q.offer(new Node(sr,sc));
        int s=image[sr][sc];
        image[sr][sc]=color;
        int[][] dist={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
           Node cur=q.poll();
           int x= cur.first;
           int y=cur.second;
           for(int[] dis:dist){
            int nx=x+dis[0];
            int ny=y+dis[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && image[nx][ny]==s){
                image[nx][ny]=color;
              q.offer(new Node(nx,ny));
            }
           }
        }


     return image;
    }

}