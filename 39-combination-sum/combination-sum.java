class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int currentSum = 0;
        List<Integer> processed = new ArrayList<>();
        List<List<Integer>> result = combinationSum(0,candidates,processed,target,currentSum);
        return result;
    }

    public static List<List<Integer>> combinationSum(int startPointer,int[] candidates, List<Integer> processed, int targetSum, int currentSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(currentSum > targetSum || currentSum + 1 == targetSum) {
            return result;
        }
        if(currentSum == targetSum) {
            result.add(processed);
            return result;
        }

        List<List<Integer>> total = new ArrayList<>();
        for(int i = startPointer; i < candidates.length; i++) {
            int sum = currentSum;
            List<Integer> p = new ArrayList<>(processed);
            sum += candidates[i];
            p.add(candidates[i]);
            total.addAll(combinationSum(i,candidates,p,targetSum,sum));
        }

        return total;
    }
}