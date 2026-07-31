class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here\
        
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<W+1;j++){
                dp[i][j]=-1;
            }
        }
        
        return recur(val,wt,n-1,W,dp);
        
    }
    
    public int recur(int[] val,int[] wt,int index,int W,int[][] dp){
        if(W==0){
            dp[index][W] = 0;
            return 0;
            
        }
        
        if(index==0){
            if(wt[index]<=W){
                dp[index][W] = val[index];
                return val[index];
            }
            dp[index][W] = 0;
            return 0;
        }
        
        if(dp[index][W]!=-1){
            return dp[index][W];
        }
        
        int pick = 0;
        if(wt[index]<=W){
            pick = val[index] + recur(val,wt,index-1,W-wt[index],dp);
        }
        
        int nopick = recur(val,wt,index-1,W,dp);
        
        dp[index][W] = Math.max(pick,nopick);
        
        return dp[index][W];
    }
}
