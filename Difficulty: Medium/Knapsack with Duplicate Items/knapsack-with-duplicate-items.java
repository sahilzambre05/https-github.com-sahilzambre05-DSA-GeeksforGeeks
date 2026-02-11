class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int dp[] = new int[capacity+1];
        dp[0]=0;
        
        for(int c = 1;c<=capacity;c++){
            int max=0;
            for(int i=0;i<wt.length;i++){
                if(wt[i]<=c){
                    int r = c-wt[i];
                    int tbag = val[i] + dp[r];
                    if(tbag>max){
                        max =  tbag;
                    }
                }
                
            }
            dp[c]=max;
        }
        return dp[capacity];
    }
}