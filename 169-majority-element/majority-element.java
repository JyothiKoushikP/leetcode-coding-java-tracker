class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = 0;
        for(int n: nums) {
            if(count == 0) {
                ele = n;
                count++;
            } else if(n == ele) {
                count++;
            } else {
                count--;
            }
        }
        return ele;
    }
}