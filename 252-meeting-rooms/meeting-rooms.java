class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                int i = Integer.compare(a[0],b[0]);
                if(i == 0) {
                    return Integer.compare(a[1],b[1]);
                }
                return i;
            }
        });
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
    }
}