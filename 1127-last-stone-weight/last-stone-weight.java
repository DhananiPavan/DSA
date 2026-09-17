class Solution {
    public int lastStoneWeight(int[] stones) {
     PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int x: stones){
            pq.add(x);
        }
        while(pq.size()!=1){
            int x=pq.poll();
            pq.add(x-pq.poll());
        }
        return pq.poll();
    }
}