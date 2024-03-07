class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int compareResult = Integer.compare(a[0], b[0]);
                if (compareResult == 0) {
                    return Integer.compare(a[1], b[1]);
                }
                return compareResult;
            }
        });
        int sum = 0;
        int i = 0;
        while(i < points.length) {
            int minX = points[i][0];
            int  minY = points[i][1];
            int j = i + 1;
            while (j < points.length && points[j][0] <= points[i][1]) {
                if(!(minX <= points[j][0] && points[j][0] <= minY)) {
                    break;
                }
                minX = Math.max(minX,points[j][0]);
                minY = Math.min(minY,points[j][1]);
                j++;
            }
            sum++;
            i = j;
        }
        return sum;
    }
}