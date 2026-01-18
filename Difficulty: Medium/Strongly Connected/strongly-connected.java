class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,adj,stack);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            visited[i] = false;
            for(Integer it : adj.get(i)){
                adjList.get(it).add(i);
            }
        }
        
        int count=0;
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]){
                count++;
                dfsCount(node,visited,adjList);
            }
        }
        return count;
        
    }
    
    public void dfs(int src,boolean[] visited,ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack){
        visited[src]=true;
        for(Integer it : adj.get(src)){
            if(!visited[it]){
                dfs(it,visited,adj,stack);
            }
        }
        stack.push(src);
    }
    
    
    public void dfsCount(int src,boolean[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[src]=true;
        for(Integer it : adj.get(src)){
            if(!visited[it]){
                dfsCount(it,visited,adj);
            }
        }
    }
}