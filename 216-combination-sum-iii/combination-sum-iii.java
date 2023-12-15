class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> processed = new ArrayList();
        boolean[] taken = new boolean[10];
        combinationSum(taken,result,processed,n,0,1,k);
        return result;
    }

       public static void combinationSum(boolean[] taken,List<List<Integer>> result, List<Integer> processed, int targetSum, int currentSum, int pointer, int k) {
        if(processed.size() == k) {
            if(currentSum != targetSum) {
                return;
            }
            if(currentSum == targetSum){
                List<Integer> p = new ArrayList<>();
                for(int ele: processed){
                    p.add(ele);
                }
                result.add(p);
                return;
            }
        }
        for(int i = pointer; i <= 9; i++) {
            if(!taken[i]) {
                processed.add(i);
                taken[i] = true;
                int size = result.size();
                combinationSum(taken,result, processed, targetSum, currentSum + i, i + 1, k);
                processed.remove(processed.size() - 1);
                taken[i] = false;
            }
        }

    }

}