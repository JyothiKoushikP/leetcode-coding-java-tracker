class Solution {
    public int singleNumber(int[] nums) {
        int[] bitPositions = new int[32];
        for(int i = 0; i < nums.length; i++) {
            int index = 31;

            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    bitPositions[index] += 1;
                }
                index--;
            }

        }

        int result = 0;
        for(int i = 0; i < bitPositions.length; i++) {
            if(bitPositions[i] % 3 != 0) {
                result += 1 << 31 - i;
            }
        }

        return result;
    }
}