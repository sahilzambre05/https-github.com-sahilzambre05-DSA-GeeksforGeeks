class Solution {
    public int maxWater(int height[]) {
        // code here
        int leftmax=0;
        int rightmax=0;
        int n = height.length;
        int count=0;
        int l = 0;
        int r = n-1;
        while(l<=r){
            if(height[l]<=height[r]){
                if(leftmax<=height[l]){
                    leftmax = height[l];
                }else{
                    count+=leftmax-height[l];
                }
                l++;
            }else{
                if(rightmax<=height[r]){
                    rightmax = height[r];
                }else{
                    count+=rightmax-height[r];
                }
                r--;

            }

        }
        return count;
        
        
    }
}
