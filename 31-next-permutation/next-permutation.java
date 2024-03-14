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


    public void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}