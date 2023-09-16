class Solution {
    public int[] sortedSquares(int[] nums) {
       int n = nums.length,start = 0, end = n-1, pos = n-1;
       int[] result = new int[n];
       while(start <= end) {
           int square1 = (int)(Math.pow(nums[start],2));
           int square2 = (int)(Math.pow(nums[end],2));
           if(square1 > square2) {
               result[pos--] = square1;
               start++;
           } else {
               result[pos--] = square2;
               end--;
           }
       }
       return result;
    }
}