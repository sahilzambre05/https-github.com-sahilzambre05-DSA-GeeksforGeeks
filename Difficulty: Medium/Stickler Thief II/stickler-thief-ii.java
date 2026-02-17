class Solution {
    public int maxValue(int[] nums) {
        // code here
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int oinc=nums[1];
        int oexc=0;
        int ninc=0;
        int nexc=0;
        for(int i=2;i<nums.length;i++){
            ninc = nums[i]+oexc;
            nexc = Math.max(oinc,oexc);
            oexc = nexc;
            oinc = ninc;
        }
        int ans1 = Math.max(oexc,ninc);

        oinc=nums[0];
        oexc=0;
        ninc=0;
        nexc=0;
        for(int i=1;i<nums.length-1;i++){
            ninc = nums[i]+oexc;
            nexc = Math.max(oinc,oexc);
            oexc = nexc;
            oinc = ninc;
        }
        int ans2 = Math.max(oexc,ninc);


        return Math.max(ans1,ans2);
    }
}
