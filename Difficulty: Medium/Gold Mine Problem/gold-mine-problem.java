class Solution {
    public int maxGold(int[][] mat) {
        // code here
         int[][] dp = new int[mat.length][mat[0].length];
        for(int j=mat[0].length-1;j>=0;j--){
            for(int i=mat.length-1;i>=0;i--){
                if(j==mat[0].length-1){
                    dp[i][j] = mat[i][j];
                }else if(i==0){
                    dp[i][j]=mat[i][j]+Math.max(dp[i][j+1],dp[i+1][j+1]);
                }else if(i==mat.length-1){
                    dp[i][j]=mat[i][j]+Math.max(dp[i][j+1],dp[i-1][j+1]);
                }else{
                    dp[i][j]=mat[i][j]+Math.max(dp[i][j+1],Math.max(dp[i+1][j+1],dp[i-1][j+1]));
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<mat.length;i++){
            if(dp[i][0]>max){
                max=dp[i][0];
            }
        }
        return max;
    
    }
}