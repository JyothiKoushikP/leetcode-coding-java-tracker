class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer,Integer> pick = new HashMap();
        Map<Integer,Integer>  drop = new HashMap();
        for(int[] trip : trips) {
            int pickUpPoint = trip[1];
            int dropPoint = trip[2];
            int people = trip[0];
            pick.put(pickUpPoint,pick.getOrDefault(pickUpPoint,0) + people);
            drop.put(dropPoint,drop.getOrDefault(dropPoint,0) + people);
        }
        int currCapacity = capacity;
        for(int i = 0; i <= 1000; i++) {
            if(drop.containsKey(i)) {
                currCapacity += drop.get(i);
            }
            if(pick.containsKey(i)) {
                if(currCapacity < pick.get(i)) {
                    return false;
                }
                currCapacity -= pick.get(i);
            }
        }

        return true;
    }
}