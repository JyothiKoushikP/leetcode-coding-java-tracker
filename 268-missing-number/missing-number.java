class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int correctIndex = arr[i];
            if(correctIndex < n && arr[i] != arr[correctIndex]) {
                swap(arr,correctIndex,i);
            } else {
                i++;
            }
        }

        for(int j = 0; j < n; j++) {
            if(arr[j] != j) {
                return j;
            }
        }

        return n;
    }

    public void swap(int[] arr, int correctIndex, int pos) {
        int temp = arr[correctIndex];
        arr[correctIndex] = arr[pos];
        arr[pos] = temp;
    }
}