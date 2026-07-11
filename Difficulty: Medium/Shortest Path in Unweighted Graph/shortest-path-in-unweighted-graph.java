class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        int[] cost = new int[V];
        Arrays.fill(cost,-1);
        cost[src] = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int n : list.get(node)){
                if(cost[n]==-1){
                    cost[n] = cost[node] + 1;
                    queue.offer(n);
                }
            }
        }
        return cost[dest];
    }
}