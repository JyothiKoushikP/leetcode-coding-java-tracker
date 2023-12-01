class Solution {
    public String convert(String s, int numRows) {
        int downDiff = (2 * numRows) - 3, upDiff = 0;
        StringBuilder res = new StringBuilder();
        if(numRows == 1) {
            return s;
        }
        for(int i = 0; i < numRows; i++) {
            if(i == 0 || i == numRows - 1) {
                downDiff = (2 * numRows) - 3;
                int j = i;
                while(j < s.length()){
                    res.append(s.charAt(j));
                    j += (downDiff) + 1;
                }
                downDiff -= 2;
                upDiff += 1;
            } else {
                int turn = 1;
                int j = i;
                while(j < s.length()){
                    res.append(s.charAt(j));
                    if(turn == 1) {
                        j += (downDiff) + 1;
                    } else {
                        j += (upDiff) + 1;
                    }
                    turn *= -1;
                }
                downDiff -= 2;
                upDiff += 2;
            }
        }
        return res.toString();
    }
}