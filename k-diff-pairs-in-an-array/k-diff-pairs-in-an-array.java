class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length, count = 0;
        StringBuilder res;
        ArrayList<Integer> num = new ArrayList();
        HashSet<String> pairs = new HashSet();
        for(int i = 0;i < n;i++) {
            res = new StringBuilder();
            int ele = nums[i];
            if(num.contains(ele + k)) {
                res.append(Integer.toString(ele));
                res.append(Integer.toString(ele + k));
                pairs.add(res.toString());
            } 
            res = new StringBuilder();
            if(num.contains(ele - k)) {
                res.append(Integer.toString(ele - k));
                res.append(Integer.toString(ele));
                pairs.add(res.toString());
            }
            num.add(ele);
        }
        return pairs.size();
    }
}