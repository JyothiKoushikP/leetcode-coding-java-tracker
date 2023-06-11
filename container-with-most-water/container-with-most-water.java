class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE,start = 0,end=height.length-1;
        while(start <= end){
            int area = (end-start) * Math.min(height[start],height[end]);
            maxArea = maxArea > area ? maxArea : area;
            if(height[start] <= height[end]){
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}