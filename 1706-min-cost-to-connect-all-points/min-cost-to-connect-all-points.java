class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        int n = points.length;  int cost = 0;
        DisjointSet ds = new DisjointSet(n);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                edges.add(new int[]{manDist(points[i], points[j]), i, j});
            }
        }
        edges.sort(
            (a,b) -> a[0] - b[0]
        );
        for(int[] edge: edges){
            if(ds.findUP(edge[1]) != ds.findUP(edge[2])){
                ds.unionBySize(edge[1], edge[2]);
                cost += edge[0];
            }
        }
        return cost;
    }
    private int manDist(int[] fir, int[] sec){
        int x = Math.abs(fir[0] - sec[0]);
        int y = Math.abs(fir[1] - sec[1]);
        return x+y;
    }
}
class DisjointSet{
    int[] parent;  int[] size;
    DisjointSet(int node){
        parent = new int[node];  size = new int[node];
        for(int i=0; i<node; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    int findUP(int node){
        if(parent[node] == node) return node;
        //path compression
        int ultiP = findUP(parent[node]);
        parent[node] = ultiP;
        return ultiP;
    }
    void unionBySize(int u, int v){
        int ult_u = findUP(u);
        int ult_v = findUP(v);
        if(ult_u == ult_v) return;

        if(size[ult_u] < size[ult_v]){
            parent[ult_u] = ult_v;
            size[ult_v] += size[ult_u];
        }
        else{
            parent[ult_v] = ult_u;
            size[ult_u] += size[ult_v];
        }
    }
}