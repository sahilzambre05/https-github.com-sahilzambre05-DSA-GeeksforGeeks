class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        dfs(0,visited,adj,res);
        return res;
    }
    
    public void dfs(int src,boolean[] visited,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> res){
        visited[src] = true;
        res.add(src);
        for(int neighbour : adj.get(src)){
            if(!visited[neighbour]){
                dfs(neighbour,visited,adj,res);
            }
        }
    }
}