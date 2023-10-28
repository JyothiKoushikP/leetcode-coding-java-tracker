class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, h = m-1;
        while (l <= h) {
            int mid = l + (h - l)/2;
            if(matrix[mid][0] == target) {
                return true;
            } else if(matrix[mid][0] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        if(h == -1) {
            h = 0;
        }
        return binarySearch(matrix, h, target);
    }

    public boolean binarySearch(int[][] matrix, int rowIndex, int target) {
        int l = 0, h = matrix[0].length - 1;
        while (l <= h) {
            int mid = l + (h - l)/2;
            if(matrix[rowIndex][mid] == target) {
                return true;
            } else if(matrix[rowIndex][mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    
}