class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateParanthesis(nums, curr, 0, result);
        result.add(new ArrayList());
        return result;
    }

    public void generateParanthesis(int[] nums, List<Integer> arr, int pointer, List<List<Integer>> result) {
        if(pointer == nums.length) {
            return;
        }
        for(int i = pointer; i < nums.length; i++) {
            arr.add(nums[i]);
            List<Integer> l1 = new ArrayList<>(arr);
            result.add(l1);
            generateParanthesis(nums, arr, i + 1, result);
            arr.remove(arr.size() - 1);
        }

        return;
    }
}