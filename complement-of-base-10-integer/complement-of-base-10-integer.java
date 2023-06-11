class Solution {
    public int bitwiseComplement(int N) {
        return N == 0 ? 1 : ((1 << (Integer.toBinaryString(N)).length()) - 1) ^ N;
    }
}