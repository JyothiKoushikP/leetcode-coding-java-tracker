class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> processed = new ArrayList<>();
        combinationSum(candidates,0,0,target,result, processed);
        return result;
    }

   public void combinationSum(int[] input, int startPointer, int currentSum,int targetSum,List<List<Integer>> result, List<Integer> processed) {
        if(currentSum > targetSum) return;
        if(currentSum == targetSum){
            result.add(processed);
            return;
        }
        for(int i = startPointer; i < input.length; i++) {
            List<Integer> p = new ArrayList<>(processed);
            p.add(input[i]);
            combinationSum(input,i,currentSum + input[i],targetSum,result,p);
        }
    }
}