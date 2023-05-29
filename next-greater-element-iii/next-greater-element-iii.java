class Solution {
    public int nextGreaterElement(int n) {
        int m = (int)(Math.log10(n)) + 1;
        int[] arr = new int[m];
        int pointer = m - 1;
        while(n != 0){
            arr[pointer--] = n % 10;
            n /= 10;
        }
        int dIndex = -1;
        for(int i = m - 2; i >= 0;i--) {
            if(arr[i] < arr[i+1]){
                dIndex = i;
                break;
            }
        }

        if(dIndex >= 0) {
            int iIndex = 0, min = Integer.MAX_VALUE;
            for(int i = dIndex+1; i < m; i++) {
                if(arr[dIndex] < arr[i]) {
                    if(min >= arr[i]){ 
                        min = arr[i];
                        iIndex = i;
                    }
                }
            }
            swapElements(arr,dIndex,iIndex);

            int p1 = dIndex + 1;
            int p2 = m - 1;

            while(p1 < p2) {
                swapElements(arr,p1++,p2--);
            }

            long result = 0;
            for(int i = 0; i < m; i++) {
                result = (result * 10) + arr[i];
            }
            if(result > Integer.MAX_VALUE) {
                return -1;
            }

            return (int)result;

        } else {
            return -1;
        }
    }

    public void swapElements(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
