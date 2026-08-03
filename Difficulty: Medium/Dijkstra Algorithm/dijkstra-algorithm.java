class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<ArrayList<Integer>>> list = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(v);
            temp1.add(w);
            list.get(u).add(temp1);
            
            ArrayList<Integer> temp2 = new ArrayList<>();
            temp2.add(u);
            temp2.add(w);
            list.get(v).add(temp2);
        }
        
        int[] dist = new int[V];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        pq.offer(new int[]{src,0});
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0];
            int d = node[1];
            for(ArrayList<Integer> a : list.get(u)){
                int v = a.get(0);
                int w = a.get(1);
                if(dist[u]+w<dist[v]){
                    dist[v] = dist[u]+w;
                    pq.offer(new int[]{v,dist[v]});
                }
                
            }
            
        }
        return dist;
    }
}