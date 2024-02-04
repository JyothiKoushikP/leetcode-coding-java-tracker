class Solution {    
    
    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length, n = image[0].length;
        int[][] prefixSum = new int[m][n];

        for(int i = 0; i < m ; i++) {
            prefixSum[i][0] = image[i][0];
            for(int j = 1; j < n; j++) {
                prefixSum[i][j] += (image[i][j] + prefixSum[i][j-1]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < m; j++) {
                prefixSum[j][i] += prefixSum[j-1][i];
            }
        }

        int[][] regionSum = new int[m][n];
        int[][] nums = new int[m][n];

        for(int i = 0; i <= m-3; i++) {
            for(int j = 0; j <= n-3; j++) {
                int lowerlimit = i+2, upperlimit = j+2;
                if(regionSum(image,i,j,lowerlimit,upperlimit,threshold) == 9) {
                    int currentSum = prefixSum[lowerlimit][upperlimit];
                    int previousSum = (lowerlimit - 3 >= 0 ? prefixSum[lowerlimit-3][upperlimit] : 0) + (upperlimit - 3 >= 0 ? prefixSum[lowerlimit][upperlimit-3] : 0) - (upperlimit - 3 >= 0 && lowerlimit - 3 >= 0 ? prefixSum[lowerlimit-3][upperlimit-3] : 0) ;
                   for(int k = i; k <= i+2; k++) {
                       for(int l = j; l <= j+2; l++) {
                            regionSum[k][l] += (currentSum - previousSum) / 9;
                            nums[k][l] += 1;
                       }
                   }
                }
            }
        }


        for(int i = 0; i < regionSum.length; i++) {
            for(int j = 0; j < regionSum[i].length; j++) {
                regionSum[i][j] = (nums[i][j] == 0) ? image[i][j] :  (regionSum[i][j] / nums[i][j]);
            }
        }

        return regionSum;
    }

    public static int regionSum(int[][] image, int r, int c, int lr, int lc, int threshold)  {
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int sum = 0;
        for(int i = r; i <= lr; i++) {
            for(int j = c; j <= lc; j++) {
                boolean isRegion = true;
                int nR = 0, nC = 0;
                for(int[] dir: dirs) {
                    if(isRegion) {
                        nR = i + dir[0]; nC = j + dir[1];
                        if(nR >= r && nR <= lr && nC >= c && nC <= lc) {
                            if( Math.abs(image[nR][nC] - image[i][j]) > threshold) isRegion = false;
                        }
                    } else {
                        break;
                    }
                }
                sum  += (isRegion) ? 1: 0;
            }
        }

        return sum;
    }
    

}