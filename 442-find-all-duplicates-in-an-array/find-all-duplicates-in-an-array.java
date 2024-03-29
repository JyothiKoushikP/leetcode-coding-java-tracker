class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]) {
                swap(arr,i,correctIndex);
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList();

        for(int j = 0; j < arr.length; j++) {
            if(arr[j] != j+1){
                result.add(arr[j]);
            }
        }

        return result;
    }

    void swap(int[] arr, int i, int correctIndex) {
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}