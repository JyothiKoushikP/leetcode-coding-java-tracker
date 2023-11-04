class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            int correct = mid + 1;
            int diff = arr[mid] - correct;
            if(diff < k){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
       
       return start + k;
    }
}