class Solution {
    public int maxWater(int height[]) {
        // Code Here
        int left=0;
        int right = height.length-1;
        int area=0;
        while(left<right){
            area = Math.max(area,((right-left)*Math.min(height[right],height[left])));
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
            
        }
        return area;
    }
}