/*
TC: O(n)
SC: O(1)
Approach:
from the right, find the index e such that a[e] > a[e-1]
now again scan from the end of the array and get the first element, which is greater than
a[e-1]
swap both (x,e-1)
if e == 0, swap the whole array
then from e to the end of the array, swap the subarray, that is your answer
*/


class Solution {
    public void nextPermutation(int[] a) {
        int p = a.length - 1;
        while(p > 0 && a[p] <= a[p-1]) {
            p--;
        }
        if(p == 0) {
            int s = 0, e = a.length - 1;
            while(s <= e) {
                swap(a,s,e);
                s++;
                e--;
            }
        } else {
            int ele = a[p-1] , e = a.length - 1;
            while(e > 0 && a[e] <= ele) {
                e--;
            }
            swap(a,p-1,e);
            e = a.length - 1;
            while(p <= e) {
                swap(a,p,e);
                p++;
                e--;
            }
        } 
    }

    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}