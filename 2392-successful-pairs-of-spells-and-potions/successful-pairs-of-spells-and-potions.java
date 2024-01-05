class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; i++) {
            int index = binarySearch(potions,success,spells[i]);
            result[i] = (index == potions.length) ? 0 : potions.length - index;
        }
        return result;
    }

    public static int binarySearch(int[] potions, long success, int spell) {
        int start = 0, end = potions.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            long pair = (long)(spell) * (long)(potions[mid]);
            if(pair >= success) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


}