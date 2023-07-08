class Solution {
    int modulo = 1000000007;
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> result = new HashMap<>();

        for (int i : nums) {
            int rev = reverse(i);
            int diff = i - rev;
            result.put(diff, result.getOrDefault(diff, 0) + 1);
        }

        long pairs = 0;

        for (int diff : result.keySet()) {
            long size = result.get(diff);
            pairs +=  (size * (size - 1)) / 2;
        }

        return (int) (pairs % modulo);
    }

    public int reverse(int n) {
        int res = 0;
        while (n != 0) {
            int rem = n % 10;
            res = (res * 10) + rem;
            n /= 10;
        }
        return res;
    }
}
