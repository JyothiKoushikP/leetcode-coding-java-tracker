class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList();

        List<Integer> res1 = new ArrayList<>(getUniqueSet(nums1,nums2));
        List<Integer> res2 = new ArrayList<>(getUniqueSet(nums2,nums1));

        result.add(res1);
        result.add(res2);
        return result;
    }

    public HashSet<Integer> getUniqueSet(int[] nums1, int[] nums2) {
        HashSet<Integer> arr2 = new HashSet();

        for(int x: nums2){
            arr2.add(x);
        }

        HashSet<Integer> arr1 = new HashSet();

        for(int x: nums1){
            if(!arr2.contains(x)) {
                arr1.add(x);
            }
        }

        return arr1;
    }

}