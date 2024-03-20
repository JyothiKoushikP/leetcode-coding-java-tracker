class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int diff = (arr[n-1] - arr[0]) / n;
        int x = arr[0];
        for(int i = 0; i < n; i++) {
            if(x != arr[i]) {
                return x;
            }
            x += diff;
        }
        return x;
    }
}