class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int start = 0, end = m - 1, r = -1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(matrix[mid][0] == target) {
                return true;
            } else if(matrix[mid][0] < target) {
                r = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if(r == -1){
            return false;
        }

        start = 0;
        end = n - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(matrix[r][mid] == target) {
                return true;
            } else if(matrix[r][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    
}