class Solution {
    public int count(int coins[], int amount) {
        // code here.
        int[] dp = new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<amount+1;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}