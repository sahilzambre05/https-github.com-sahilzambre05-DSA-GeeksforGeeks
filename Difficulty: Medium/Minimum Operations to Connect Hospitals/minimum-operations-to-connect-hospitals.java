class Solution {
    public int minConnect(int n, int[][] connections) {
        // code here
        if(connections.length<n-1){
            return -1;
        }

        DisjointSet dsu = new DisjointSet(n);
        int wire=0;
        for(int connection[] : connections){
            int u = connection[0];
            int v = connection[1];
            if(dsu.unionBySize(u,v)){
                wire++;
            }
        }
        return n-1-wire;
    }
}


class DisjointSet{
    int[] parent;
    int[] size;
    DisjointSet(int node){
        this.parent = new int[node];
        this.size = new int[node];

        for(int i=0;i<node;i++){
            parent[i] = i;
            size[i]=1;
        }
    }

    public int findNodeParent(int node){
        if(node==parent[node]){
            return node;
        }
        parent[node] = findNodeParent(parent[node]);
        return parent[node];
    }

    public boolean unionBySize(int node1,int node2){
        int rootParent1 = findNodeParent(node1);
        int rootParent2 = findNodeParent(node2);

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