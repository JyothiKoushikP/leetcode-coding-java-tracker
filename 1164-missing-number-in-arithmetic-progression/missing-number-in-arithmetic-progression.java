/*

Linear Search : O(n)
Binary Search: O(log(n))

*/


class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int diff = (arr[n-1] - arr[0]) / n;
        int start = 0, end = n - 1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(arr[mid] == arr[0] + (mid * diff)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return arr[0] + (end * diff);
    }
}