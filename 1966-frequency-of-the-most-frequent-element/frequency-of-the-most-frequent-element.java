class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long[] prefixArray = new long[nums.length];
        
        for(int i = 1; i < nums.length; i++) {
            prefixArray[i] = nums[i] + prefixArray[i-1];
        }

        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            int count = binarySearch(nums,prefixArray,k,i);
            maxCount = Math.max(maxCount,count);
        }

        return maxCount;
    }

    public int binarySearch(int[] nums, long[] prefix, int k, int i) {
        int target = nums[i];
        int start = 0, end = i, best = i;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long count = (i - mid + 1);
            long originalSum = prefix[i] - prefix[mid] + nums[mid];
            long totalSum = (count * target) - originalSum;
            if(totalSum > k) {
                start = mid + 1;
            } else {
                best = mid;
                end = mid - 1;
            }
        }
        return i - best + 1;
    }


}