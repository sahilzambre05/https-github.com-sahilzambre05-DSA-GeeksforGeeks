class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue =  new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        queue.offer(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                    
                }
            }
        }
        return res;
    }
}