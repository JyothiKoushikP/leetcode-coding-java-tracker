class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length, boats = 0;
        int start = 0, end = n - 1;
        while(start <= end) {
            int totalWeight = people[start] + people[end];
            if(totalWeight > limit) {
                boats++;
                end--;
            } else {
                boats++;
                start++;
                end--;
            }
        }
        return boats;
    }
}