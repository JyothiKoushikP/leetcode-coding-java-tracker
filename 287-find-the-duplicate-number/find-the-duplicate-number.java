class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] freq = new int[100001];
        for(int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        for(int i = 1; i <= n - 1; i++) {
            if(freq[i] > 1){
                return i;
            }
        }

        return 0;
    }
}