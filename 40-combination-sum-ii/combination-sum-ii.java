class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void cs2(int index, int sum, int targetSum,List<Integer> processed,int[] candidates) {
        if(index > candidates.length || sum > targetSum) {
            return;
        }
        if(sum == targetSum) {
            List<Integer> r = new ArrayList<>();
            for(int i: processed) {
                r.add(i);
            }
            result.add(r);
            return;
        }
            for(int i = index; i < candidates.length; i++) {
                if(i == index || candidates[i-1] != candidates[i]) {
                    processed.add(candidates[i]);
                    cs2(i + 1,sum + candidates[i],targetSum,processed,candidates);
                    processed.remove(processed.size() - 1);
                }
            }

    }



    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        cs2(0,0,target,new ArrayList<>(),candidates);
        return result;
    }


    
            
}
