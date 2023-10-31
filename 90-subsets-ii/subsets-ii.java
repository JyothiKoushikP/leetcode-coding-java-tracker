class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        result.add(new ArrayList());
        int start = 0,end = 0;
        for(int i = 0; i < nums.length; i++) {
            start = 0;
            int n = result.size();
            if(i > 0 && nums[i-1] == nums[i]) {
                start = end + 1;
            } 
            end = result.size() - 1;
            for(int j = start; j < n; j++) {
                List<Integer> innerArray = new ArrayList<>(result.get(j));
                innerArray.add(nums[i]);
                result.add(innerArray);
            }
        }  
        return result;
    }
}