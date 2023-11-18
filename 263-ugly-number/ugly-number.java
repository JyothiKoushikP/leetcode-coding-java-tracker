class Solution {
    public boolean isUgly(int n) {
        if(n == 0) return false;
        if(n == 1) return true;
        
        HashSet<Integer> res = new HashSet();

        for (int i = 2; i <= 5; i++) {
            while (n % i == 0) {
                res.add(i);
                System.out.print(i + " ");
                n /= i;
            }
        }

        return n == 1;
    }
}