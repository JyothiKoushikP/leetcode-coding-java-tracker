class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> processed = new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> result = permutationsList(0,processed,nums);
        return result;
    }

    public static List<List<Integer>> permutationsList(int curr, List<Integer> processed, int[] nums) {
        if (curr == nums.length) {
            List<List<Integer>> finalList = new ArrayList<>();
            finalList.add(processed);
            return finalList;
        }

        List<List<Integer>> ans = new ArrayList<>();

        int i = 0;
        if(curr > 0 && (nums[curr-1] == nums[curr])) {
            int lastIndex = -1;
            for (int j = processed.size() - 1; j >= 0; j--) {
                if (processed.get(j) == nums[curr]) {
                    lastIndex = j;
                    break; // Stop the loop once the last occurrence is found
                }
            }
            i = lastIndex + 1;
        }
        while(i <= processed.size()) {
            List<Integer> mergedList = new ArrayList<>();
            List<Integer> f = processed.subList(0,i);
            mergedList.addAll(f);
            mergedList.add(nums[curr]);
            List<Integer> s = processed.subList(i, processed.size());
            mergedList.addAll(s);
            int p = curr;
            ans.addAll(permutationsList(curr + 1, mergedList, nums));
            i++;
        }
        return ans;
    }
}