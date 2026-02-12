// User function Template for Java

class Solution {
    int countStrings(int n) {
        // code here
        int[] dp0 = new int[n+1];
        int[] dp1 = new int[n+1];
        
        dp0[1]=1;
        dp1[1]=1;
        
        for(int i=2;i<=n;i++){
            dp0[i] = dp0[i-1]+dp1[i-1];
            dp1[i] = dp0[i-1];
        }
        
        return dp0[n]+dp1[n];
    }
}