class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> empty = new ArrayList<>();
        List<List<Integer>> result = combinations(1,n,k,empty);
        return result;
    }

    public List<List<Integer>> combinations(int startPointer, int n, int k, List<Integer> empty) {
        if((startPointer == n && empty.size() == k) || (empty.size() == k)) {
            List<List<Integer>> f = new ArrayList<>();
            f.add(empty);
            return f;
        }
        List<List<Integer>> e = new ArrayList<>();
        for(int i = startPointer; i <= n; i++) {
            List<Integer> result = new ArrayList<>(empty);
            result.add(i);
            e.addAll(combinations(i + 1, n, k, result));
        }

        return e;
    }


}