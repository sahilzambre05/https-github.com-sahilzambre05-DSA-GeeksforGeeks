class Solution {
    int countWays(int n) {
        // your code here
        int qb[] = new int[n+1];
        qb[0]=1;
        for(int i=1;i<=n;i++){
            if(i==1){
                qb[i]=qb[i-1];
            }else{
                qb[i] = qb[i-1]+qb[i-2];
            }
        }
        return qb[n];
    
    }
}
