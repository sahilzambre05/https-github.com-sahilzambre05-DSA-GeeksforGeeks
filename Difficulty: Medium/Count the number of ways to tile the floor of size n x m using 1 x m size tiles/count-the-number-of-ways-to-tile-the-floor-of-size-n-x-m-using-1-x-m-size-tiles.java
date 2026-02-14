// User function Template for Java

class Solution {
    public int countWays(int n, int m) {
        // Code here
        int MOD = 1000000007;
        long[] dp = new long[n+1];
        for(int i=1;i<=n;i++){
            if(i<m){
                dp[i]=1;
            }else if(i==m){
                dp[i]=2;
            }else{
                dp[i]=(dp[i-1]+dp[i-m])%MOD;
            }
            
        }
        return (int)dp[n];
    }
}