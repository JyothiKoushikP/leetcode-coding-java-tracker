class Solution {
    public long sumDigitDifferences(int[] nums) {
        int digits = (int) Math.floor(Math.log10(Math.abs(nums[0])) + 1);
        int[][] result = new int[digits][nums.length];
        for(int i = 0; i <nums.length; i++) {
            int count = 0;
            int temp = nums[i];
            while(temp > 0) {
                int rem = temp % 10;
                result[count++][i] = rem;
                temp /= 10;
            }
        }

        long sum = 0L;
        for(int[] row: result) {
            Map<Integer,Integer> track = new HashMap<>();
            for(int i: row) {
                track.put(i,track.getOrDefault(i,0) + 1);
            }


            for(int i = 0; i < row.length; i++) {
                int allSet = row.length - i - 1;
                sum += (allSet - (track.get(row[i]) - 1));
                if(track.get(row[i]) == 1) {
                    track.remove(row[i]);
                } else {
                    track.put(row[i],track.get(row[i]) - 1);
                }
            }

        }

        return sum;
    }
}