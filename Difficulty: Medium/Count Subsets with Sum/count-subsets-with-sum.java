class Solution {
    static int perfectSum(int[] arr, int target) {
        // code here
        int ans = 0;
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<target+1;j++){
                dp[i][j] = -1;
            }
        }
        ans = recur(arr,target,n-1,dp);
        return ans;
    }
    
    public static int recur(int[] arr,int target,int index,int[][] dp){
        if(index==0){
            if(target==0 && arr[index]==0){
                dp[index][target] = 2;
                return 2;
            }else if(target==0){
                dp[index][target] = 1;
                return 1;
            }else if(target==arr[index]){
                dp[index][target] = 1;
                return 1;
            }else{
                dp[index][target] = 0;
                return 0;
            }
        }
        
        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        
        int pick=0;
        if(arr[index]<=target){
            pick = recur(arr,target-arr[index],index-1,dp);
        }
        
        int nopick = recur(arr,target,index-1,dp);
        
        dp[index][target] = pick+nopick;
        
        return dp[index][target];
    }
}