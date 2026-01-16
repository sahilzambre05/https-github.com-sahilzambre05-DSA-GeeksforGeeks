// User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int n = adj.size();
        DisjointSet dsu = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj.get(i).get(j) == 1) {
                    dsu.unionBySize(i, j);
                }
            }
        }


        int ans=0;
        for(int i=0;i<n;i++){
            if(dsu.findRootParent(i)==i){
                ans++;
            }
        }
        return ans;
        
    }
}

class DisjointSet{
    int[] parent;
    int[] size;

    DisjointSet(int node){
        this.parent = new int[node];
        this.size = new int[node];
        for(int i=0;i<node;i++){
            parent[i]=i;
            size[i]=1;
        }
    }


    public int findRootParent(int node){
        if(node==parent[node]){
            return node;
        }
        parent[node] = findRootParent(parent[node]);
        return parent[node];
    }

    public boolean unionBySize(int node1,int node2){
        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);

        if(rootParent1==rootParent2){
            return false;
        }

        if(size[rootParent1]<size[rootParent2]){
            parent[rootParent1]=rootParent2;
            size[rootParent2]+=size[rootParent1];
        }else{
            parent[rootParent2]=rootParent1;
            size[rootParent1]+=size[rootParent2];

        }
        return true;
    }
}