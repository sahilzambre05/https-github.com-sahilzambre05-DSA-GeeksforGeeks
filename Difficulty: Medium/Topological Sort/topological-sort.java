class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
        }
        
        int[] inDegree = new int[V];
        for(int i=0;i<list.size();i++){
            for(int u : list.get(i)){
                inDegree[u]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for(int neighbour : list.get(node)){
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
            
            
        }
        return res;
    }
}