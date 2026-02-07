class Solution {
    public int nthFibonacci(int n) {
        // code here
        int qb[] = new int[n+1];
        int fib = count(n,qb);
        return fib;
    }
    
    public int count(int n,int[] qb){
        if(n==0||n==1){
            return n;
        }
        if(qb[n]!=0){
            return qb[n];
        }
        
        int ans = count(n-1,qb)+count(n-2,qb);
        qb[n]=ans;
        
        return ans;
        
    }
}