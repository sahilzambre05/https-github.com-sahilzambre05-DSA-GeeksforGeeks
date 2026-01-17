class Solution {

    public boolean isBipartite(int V, int[][] edges) {

        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // Step 2: LeetCode-style BFS coloring
        int[] colour = new int[V];
        Arrays.fill(colour, -1);

        for (int i = 0; i < V; i++) {
            if (colour[i] == -1) {
                if (!bfs(i, adj, colour)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int src, List<List<Integer>> adj, int[] colour) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        colour[src] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbour : adj.get(node)) {
                if (colour[neighbour] == -1) {
                    colour[neighbour] = 1 - colour[node];
                    q.offer(neighbour);
                } else if (colour[neighbour] == colour[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
