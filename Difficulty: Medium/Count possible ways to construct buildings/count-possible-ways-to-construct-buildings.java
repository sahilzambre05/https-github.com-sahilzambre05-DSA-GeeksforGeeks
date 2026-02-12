class Solution {
    public int TotalWays(int N) {
        int MOD = 1000000007;
        
        int[] dp0 = new int[N+1];
        int[] dp1 = new int[N+1];
        
        dp0[1] = 1;
        dp1[1] = 1;
        
        for(int i = 2; i <= N; i++){
            dp0[i] = (dp0[i-1] + dp1[i-1]) % MOD;
            dp1[i] = dp0[i-1] % MOD;
        }
        
        long total = (dp0[N] + dp1[N]) % MOD;
        total = (total * total) % MOD;
        
        return (int) total;
    }
}
