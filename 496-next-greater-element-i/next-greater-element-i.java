class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> indexTrack = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            indexTrack.put(nums1[i],i);
        }
        Stack<Integer> geStack = new Stack<>();
        int[] res = new int[nums1.length];
        for(int i = nums2.length - 1; i >= 0; i--) {
            while(geStack.size() > 0 && geStack.peek() <= nums2[i]) {
                geStack.pop();
            }

            if(indexTrack.containsKey(nums2[i])) {
                int index = indexTrack.get(nums2[i]);
                if(geStack.size() == 0) {
                    res[index] = -1;
                } else {
                    res[index] = geStack.peek();
                }
            }

            geStack.push(nums2[i]);
        }

        return res;
    }

    
}