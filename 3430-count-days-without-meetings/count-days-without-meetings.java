class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i = Integer.compare(o1[0], o2[0]);
                if(i == 0) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return i;
            }
        });
        int i = 0, j = 1, count = 0;
        while(i < meetings.length - 1 && j < meetings.length) {
            if(meetings[i][1] >= meetings[j][0]) {
                if(meetings[i][0] > meetings[j][0]) {
                    meetings[i][0] = meetings[j][0];
                }
                if(meetings[i][1] < meetings[j][1]) {
                    meetings[i][1] = meetings[j][1];
                }
                meetings[j][0] = Integer.MIN_VALUE;
                j++;
                count++;
            } else {
                i++;
                while(i < meetings.length - 1 && meetings[i][0] == Integer.MIN_VALUE) i++;
                j++;
            }
        }
        int[][] result = new int[meetings.length - count][2];
        int p = 0;
        for(int[] row: meetings) {
            if(row[0] != Integer.MIN_VALUE) {
                result[p][0] = row[0];
                result[p++][1] = row[1];
            }
        }
        int total = days;
        int occupied = 0;
        for(int[] row: result) {
            occupied += (row[1] - row[0]) + 1;
        }
        return total - occupied;
    }
}