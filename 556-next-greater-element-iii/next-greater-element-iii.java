class Solution {
    public int nextGreaterElement(int n) {
        int digits = (int)(Math.log10(n)) + 1;
        int[] result = new int[digits];
        int pointer = digits - 1;
        while(n > 0) {
            int rem = n % 10;
            result[pointer--] = rem;
            n /= 10;
        }
        pointer = digits - 2;
        while(pointer >= 0){
            if(result[pointer] < result[pointer+1]) {
                break;
            }
            pointer--;
        }
        if(pointer == -1) {
            return -1;
        }

        int min = Integer.MAX_VALUE, minIndex = -1;
        for(int i = pointer + 1; i < digits; i++) {
            if(result[pointer] < result[i]) {
                if(min >= result[i]){ 
                    min = result[i];
                    minIndex = i;
                }
            }
        }

        swap(result,pointer,minIndex);

        int start = pointer + 1, end = result.length-1;
        while(start <= end) {
            swap(result,start,end);
            start++;
            end--;
        }
        
        long changed = 0L;

        for(int i = 0; i < digits; i++) {
            changed = (changed * 10) + result[i];
        }

        return changed > Integer.MAX_VALUE ? -1 : (int)(changed);
    }

    public void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}