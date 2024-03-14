class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        Integer ele1 = null, ele2 = null;
        for(int n: nums) {
            if(ele1 != null && ele1 == n){
                count1++;
            } else if(ele2 != null && ele2 == n) {
                count2++;
            } else if(count1 == 0) {
                ele1 = n;
                count1++;
            } else if(count2 == 0) {
                ele2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        int c1 = 0, c2 = 0;
        List<Integer> result = new ArrayList<>();
        for(int n: nums) {
            if(ele1 != null && n == ele1) c1++;
            if(ele2 != null && n == ele2) c2++;
        }

        int n = nums.length;
        if(c1 > n/3) result.add(ele1);
        if(c2 > n/3) result.add(ele2);

        return result;
    }
}