class Solution {
    public int valueAfterKSeconds(int n, int k) {
        long count = 0;
        int mod = 1000000007;
        long[] arr = new long[n];
        Arrays.fill(arr,1);
        while(count < k) {
            for(int i = 1; i < n; i++) {
                arr[i] = (arr[i] + arr[i-1]) % mod;
            }
            count++;
        }
        return (int)(arr[n-1]);
    }
}