class Solution {
    public int knapsack(int W, int wt[], int val[]) {
        // code here
        int dp[][] = new int[val.length+1][W+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j>=val[i-1]){
                    int rWt = j-val[i-1];
                    if(dp[i-1][rWt]+wt[i-1]>dp[i-1][j]){
                        dp[i][j] = dp[i-1][rWt]+wt[i-1];
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                    
                    
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[val.length][W];
    }
}
