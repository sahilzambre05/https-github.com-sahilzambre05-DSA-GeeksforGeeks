class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(price,n,n-1,dp);
        
    }
    
    public int recur(int[] price,int size,int index,int[][] dp){
        if(index==0){
            dp[index][size] = size*price[0];
            return size*price[0];
        }
        
        if(dp[index][size]!=-1){
            return dp[index][size];
        }
        
        int pick = 0;
        if(size>=index+1){
            pick = price[index] + recur(price,size-(index+1),index,dp);
        }
        
        int nopick = recur(price,size,index-1,dp);
        
        dp[index][size] = Math.max(pick,nopick);
        
        return dp[index][size];
    }
}