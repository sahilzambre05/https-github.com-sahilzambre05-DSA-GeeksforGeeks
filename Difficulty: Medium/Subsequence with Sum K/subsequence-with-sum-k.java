class Solution {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        // code here
        return recur(arr,arr.length-1,k);
        
    }
    
    public boolean recur(int[] arr,int index,int k){
        if(k==0){
            return true;
        }
        
        if(index==0){
            if(arr[index]==k) return true;
            return false;
        }
        
        boolean pick = false;
        if(arr[index]<=k){
            pick = recur(arr,index-1,k-arr[index]);
            if(pick){
                return true;
            }
        }
        
        boolean nopick = recur(arr,index-1,k);
        
        return nopick;
    }
}