class Solution {
    public int minOperations(int n) {
        int[] bits = new int[32];
        int pointer = bits.length - 1;
        while(n > 0) {
            int rem = n % 2;
            bits[pointer--] = rem;
            n /= 2;
        }
        pointer = bits.length - 1;
        int sum = 0;
        while(pointer >= 0) {
            if(bits[pointer] == 1) {
                int x = pointer;
                while(x >= 0 && bits[x] != 0) {
                    x--;
                }
                if(pointer - x == 1) {
                    bits[pointer] = 0;
                    sum++;
                } else if(x >= 0){
                    bits[x] = 1;
                    sum++;
                    for(int j = x + 1 ; j <= pointer; j++) {
                        bits[j] = 0;
                    }
                } 
                pointer = x;
            } else {
                pointer--;
            } 
        }
        return sum;
    }
}