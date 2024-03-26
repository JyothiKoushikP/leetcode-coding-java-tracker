/*
TC: O(nlogn)
SC: O(logn)
Logic: Sort by ending times
*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                int i = Integer.compare(a[1],b[1]);
                return i;
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        int deletions = 0;
        for(int i = 1; i < intervals.length; i++) {
            int currS = intervals[i][0];
            int currE = intervals[i][1];
            if(currS >= end) {
                start = currS;
                end = currE;
            } else {
                deletions += 1;
            }
        }
        return deletions;
    }
}