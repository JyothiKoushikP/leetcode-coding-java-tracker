class Solution {
    public int findPairs(int[] nums, int k) {
        HashSet<String> pairs = new HashSet<>();
        HashSet<Integer> numSet = new HashSet<>();

        for (int ele : nums) {
            if (numSet.contains(ele + k)) {
                pairs.add((ele + k) + "-" + ele);
            }
            if (numSet.contains(ele - k)) {
                pairs.add(ele + "-" + (ele - k));
            }
            numSet.add(ele);
        }

        return pairs.size();
}

}