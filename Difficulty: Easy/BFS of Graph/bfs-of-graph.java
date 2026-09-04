class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[adj.size()];
        visited[0] = true;
        // res.add(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for(int n : adj.get(node)){
                if(!visited[n]){
                    queue.offer(n);
                    visited[n] = true;
                    
                }
            }
        }
        return res;
    }
}