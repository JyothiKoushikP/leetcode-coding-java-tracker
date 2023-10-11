class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList();
        int i = 0, n = nums.length;
        while(i < n) {
            int correctIndex = nums[i] - 1;
            if(nums[correctIndex] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != j + 1) {
                result.add(j+1);
            }
        }

        return result;
    }
}