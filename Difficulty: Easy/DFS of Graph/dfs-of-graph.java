class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int n = adj.size();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,adj,visited,res);
            }
        }
        return res;
    }
    
    public void dfs(int src,ArrayList<ArrayList<Integer>> adj,boolean[] visited,ArrayList<Integer> res){
        visited[src] = true;
        res.add(src);
        
        for(int node : adj.get(src)){
            if(!visited[node]){
                dfs(node,adj,visited,res);
            }
        }
        return;
    }
}