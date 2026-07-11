class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(bfs(i,visited,list)){
                    return true;
                }
            }
        }
        return false;
        
    }
    
    public boolean bfs(int src,boolean[] visited, List<List<Integer>> list){
        visited[src] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src,-1});
        while(!queue.isEmpty()){
            int node[] = queue.poll();
            int child = node[0];
            int parent = node[1];
            for(int neighbour : list.get(child)){
                if(neighbour==parent) continue;
                if(visited[neighbour]) return true;
                visited[neighbour] = true;
                queue.offer(new int[]{neighbour,child});
            }
        }
        return false;
    }
}