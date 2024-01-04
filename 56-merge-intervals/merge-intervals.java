class Solution {
    public int[][] merge(int[][] intervals) {
        int count = 0;
        int[][] sorted = mergeSort(intervals,0,intervals.length - 1);
        int i = 0, j = 1;
        while(i < sorted.length - 1 && j < sorted.length) {
            if(sorted[i][1] >= sorted[j][0]) {
                if(sorted[i][0] > sorted[j][0]) {
                    sorted[i][0] = sorted[j][0];
                }
                if(sorted[i][1] < sorted[j][1]) {
                    sorted[i][1] = sorted[j][1];
                }
                sorted[j][0] = Integer.MIN_VALUE;
                j++;
                count++;
            } else {
                i++;
                while(i < sorted.length - 1 && sorted[i][0] == Integer.MIN_VALUE) i++;
                j++;
            }
        }
        int[][] result = new int[sorted.length - count][2];
        int p = 0;
        for(int[] row: sorted) {
            if(row[0] != Integer.MIN_VALUE) {
                result[p][0] = row[0];
                result[p++][1] = row[1];
            }
        }
        return result;
    }
    public int[][] mergeSort(int[][] input, int start, int end) {
        if(start == end) {
            return new int[][]{input[start]};
        }
        int mid = start + (end - start)/2;
        int[][] arr1 = mergeSort(input,start,mid);
        int[][] arr2 = mergeSort(input,mid + 1,end);

        int[][] result = new int[arr1.length + arr2.length][2];
        int m = 0, n = 0,p = 0;
        while(m < arr1.length && n < arr2.length) {
            if(arr1[m][0] >= arr2[n][0]) {
                result[p++] = arr2[n++];
            } else {
                result[p++] = arr1[m++];
            }
        }
        while(m < arr1.length) {
            result[p++] = arr1[m++];
        }
        while(n < arr2.length) {
            result[p++] = arr2[n++];
        }

        return result;
    }
}