class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
        }
        
        boolean visited[] = new boolean[V];
        boolean pathVisited[] = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,visited,pathVisited,list)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int src,boolean visited[],boolean pathVisited[], List<List<Integer>> list){
        visited[src] = true;
        pathVisited[src] = true;
        for(int neighbour : list.get(src)){
            if(pathVisited[neighbour]) return true;
            if(visited[neighbour]) continue;
            if(dfs(neighbour,visited,pathVisited,list)) return true;
        }
        pathVisited[src] = false;
        return false;
        
    }

    
}