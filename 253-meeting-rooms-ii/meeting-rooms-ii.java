class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer,Integer> start = new HashMap();
        Map<Integer,Integer> end = new HashMap();
        for(int[] interval: intervals) {
            int startTime = interval[0];
            int endTime = interval[1];
            start.put(startTime,start.getOrDefault(startTime,0) + 1);
            end.put(endTime,end.getOrDefault(endTime,0) + 1);
        }
        int vacant = 0, totalRooms = 0;
        for(int i = 0; i <= 1000000; i++) {
            if(end.containsKey(i)) {
                vacant += end.get(i);
            }
            if(start.containsKey(i)) {
                if(vacant == 0) {
                    totalRooms += start.get(i);
                } else {
                    if(vacant <= start.get(i)) {
                        totalRooms += (start.get(i) - vacant);
                        vacant = 0;
                    } else {
                        vacant -= start.get(i);
                    }
                }
            }
        }
        return totalRooms;
    }
}