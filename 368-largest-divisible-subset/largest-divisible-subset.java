class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[] track = new ArrayList[nums.length];
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        track[0] = first;
        for(int i = 1; i < nums.length; i++) {
            int maxLength = Integer.MIN_VALUE, maxIndex = -1;
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0) {
                    if(track[j].size() > maxLength) {
                        maxLength = track[j].size();
                        maxIndex = j;
                    }
                }
            }
            List<Integer> arr = maxIndex == -1 ? new ArrayList<>() : new ArrayList<>(track[maxIndex]);
            arr.add(nums[i]);
            track[i] = arr;
        }
        int maxLength = 0;
        for (List<Integer> integers : track) {
            maxLength = Math.max(maxLength, integers.size());
        }
        for (List<Integer> integers : track) {
            if (integers.size() == maxLength) {
                return integers;
            }
        }
        return new ArrayList<>();
    }
}