class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> processed = new ArrayList<>();
        List<List<Integer>> result = permutationsList(processed,nums,0);
        return result;
    }

    public List<List<Integer>> permutationsList(List<Integer> processed, int[] nums, int pointer) {
        if (pointer == nums.length) {
            List<List<Integer>> finalList = new ArrayList<>();
            finalList.add(processed);
            return finalList;
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i <= processed.size(); i++) {
            List<Integer> mergedList = new ArrayList<>();
            List<Integer> f = processed.subList(0,i);
            mergedList.addAll(f);
            mergedList.add(nums[pointer]);
            List<Integer> s = processed.subList(i, processed.size());
            mergedList.addAll(s);
            ans.addAll(permutationsList(mergedList,nums,pointer + 1));
        }
        return ans;
    }
}