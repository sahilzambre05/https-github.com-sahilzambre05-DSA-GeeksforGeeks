class Solution {
    int maxProfit(int prices[], int k) {
        // code here
         int dp[][] = new int[k+1][prices.length];
        for(int t=1;t<=k;t++){
            int max = Integer.MIN_VALUE;
            for(int d=1;d<prices.length;d++){
                if(dp[t-1][d-1] - prices[d-1] > max){
                    max = dp[t-1][d-1] - prices[d-1];
                }

                if(max + prices[d] > dp[t][d-1]){
                    dp[t][d] = max + prices[d];
                }else{
                    dp[t][d] = dp[t][d-1];
                }
            }
        }
        return dp[k][prices.length-1];
    }
}