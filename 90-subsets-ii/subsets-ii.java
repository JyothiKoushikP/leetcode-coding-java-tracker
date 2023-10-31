class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int curr = 0;
        Arrays.sort(nums);
        result.add(new ArrayList());
        for(int i = 0; i < nums.length; i++) {
            int n = result.size();
            for(int j = 0; j < n; j++) {
                List<Integer> innerArray = new ArrayList<>(result.get(j));
                innerArray.add(nums[i]);
                if(!result.contains(innerArray)) {
                    result.add(innerArray);
                }
            }
        }  
        return result;
    }
}