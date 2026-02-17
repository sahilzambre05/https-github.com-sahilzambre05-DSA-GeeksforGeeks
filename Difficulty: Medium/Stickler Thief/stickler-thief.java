class Solution {
    public int findMaxSum(int nums[]) {
        // code here
        int oinc=nums[0];
        int oexc=0;
        int ninc=0;
        int nexc=0;
        for(int i=1;i<nums.length;i++){
            ninc = nums[i]+oexc;
            nexc = Math.max(oinc,oexc);
            oexc = nexc;
            oinc = ninc;
        }

        return Math.max(oexc,oinc);
    }
}