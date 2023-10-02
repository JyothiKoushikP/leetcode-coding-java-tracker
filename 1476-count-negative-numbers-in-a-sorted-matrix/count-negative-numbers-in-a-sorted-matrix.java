class Solution {
    public int countNegatives(int[][] grid) {
        int result = 0;
        int n = grid[0].length;
        for(int[] row: grid) {
            int index = binarySearch(row);
            result += (n - index);
        }
        return result;
    }

    public int binarySearch(int[] arr) {
        int n = arr.length, start = 0, end = n-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(arr[mid] < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}