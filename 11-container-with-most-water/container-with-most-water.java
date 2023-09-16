class Solution {
    public int maxArea(int[] height) {
        int n = height.length, start = 0, end = n-1;
        int maxArea = 0;
        while(start < end) {
            int b = Math.min(height[start],height[end]);
            int l = end - start;
            maxArea = Math.max(maxArea,l*b);
            if(height[start] <= height[end]){
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}