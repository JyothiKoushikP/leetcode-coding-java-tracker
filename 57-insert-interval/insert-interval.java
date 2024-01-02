class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int ns = newInterval[0], ne = newInterval[1];
        int index = -1;
        boolean didChange = false;
        for(int[] interval: intervals) {
            int s = interval[0], e = interval[1];
            index++;
            if (ns > e || ne < s) {
            } else if (ns >= s && ne <= e) {
                didChange = true;
                break;
            } else if (ns >= s && ne > e) {
                didChange = true;
                interval[1] = ne;
                break;
            } else if (ns == e) {
                didChange = true;
                interval[1] = ne;
                break;
            } else if (ns < s && ne > e) {
                didChange = true;
                interval[0] = ns;
                interval[1] = ne;
                break;
            } else if (ns < s && ne <= e) {
                didChange = true;
                interval[0] = ns;
                break;
            }
        }

        if(!didChange) {
            int[][] newArray = new int[intervals.length + 1][2];
            if(intervals.length == 0) {
                newArray[0][0] = ns;
                newArray[0][1] = ne;
                return newArray;
            }
            int i = 0,pointer = 0;
            while(i < intervals.length && intervals[i][0] < ns) {
                newArray[pointer][0] = intervals[i][0];
                newArray[pointer++][1] = intervals[i++][1];
            }
            newArray[pointer][0] = ns;
            newArray[pointer++][1] = ne;
            while(i < intervals.length) {
                newArray[pointer][0] = intervals[i][0];
                newArray[pointer++][1] = intervals[i++][1];
            }
            return newArray;
        } else {
            ns = intervals[index][0];
            ne = intervals[index][1];
            int len = intervals.length;
            for(int i = index + 1; i < intervals.length; i++) {
                int s = intervals[i][0], e = intervals[i][1];
                if(s > ne) {
                    break;
                } else if(s >= ns){
                    if(e <= ne) {}
                    else {
                        intervals[index][1] = e;
                    }
                } else if(s == ne) {
                    intervals[index][1] = e;
                }
                intervals[i][0] = Integer.MIN_VALUE;
                len--;
                ns = intervals[index][0];
                ne = intervals[index][1];
            }
            int[][] newArray = new int[len][2];
            int i = 0;
            for(int[] interval: intervals){
                if(interval[0] != Integer.MIN_VALUE) {
                    newArray[i][0] = interval[0];
                    newArray[i][1] = interval[1];
                    i++;
                }
            }
            return newArray;
        }
    }
}