class Solution {
    public int maxSumIS(int arr[]) {
        // code here
        int[] dp = new int[arr.length];
        int omax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            Integer max = null;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    if(max==null){
                        max = dp[j];
                    }else if(dp[j]>max){
                        max = dp[j];
                    }
                }
                
            }
                if(max==null){
                    dp[i] = arr[i];
                }else{
                    dp[i] = max+arr[i];
                }
                
                
                if(dp[i]>omax){
                    omax = dp[i];
                }
        }
        return omax;
    }
}