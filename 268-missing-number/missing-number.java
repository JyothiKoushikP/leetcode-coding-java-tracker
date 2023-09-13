class Solution {
    public int missingNumber(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correctIndex = arr[i];
            if (correctIndex < arr.length && arr[correctIndex] != arr[i]) {
               swap(correctIndex,i,arr);
            } else {
                i++;
            }
        }

        for(int j = 0; j < arr.length; j++) {
            if(arr[j] != j) {
                return j;
            }
        }

        return arr.length;
    }

    public void swap(int pos1, int pos2, int[] arr) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

}