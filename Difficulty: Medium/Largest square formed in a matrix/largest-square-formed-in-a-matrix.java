// User function Template for Java

class Solution {
    static int maxSquare(int matrix[][]) {
        // code here
         int m = matrix.length;
        int n = matrix[0].length;

        int ans = 0;

        int dp[][] = new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[i][j]=matrix[i][j];
                }else if(i==m-1){
                    dp[i][j]=matrix[i][j];

                }else if(j==n-1){
                    dp[i][j]=matrix[i][j];

                }else{
                    if(matrix[i][j]==0){
                        dp[i][j]=0;
                    }else{
                        int min = Math.min(dp[i+1][j],dp[i][j+1]);
                        dp[i][j] = Math.min(dp[i+1][j+1],min)+1;
                    }

                }
                        ans = Math.max(ans, dp[i][j]);
        
            }
        }
        return ans;
    }
}