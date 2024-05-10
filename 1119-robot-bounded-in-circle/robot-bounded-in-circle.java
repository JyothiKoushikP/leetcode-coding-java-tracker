class Solution {
    Map<Character,Character> left = new HashMap<>();
    Map<Character,Character> right = new HashMap<>();

    public boolean isRobotBounded(String instructions) {
        left.put('N','W');
        left.put('W','S');
        left.put('S','E');
        left.put('E','N');

        right.put('N','E');
        right.put('E','S');
        right.put('S','W');
        right.put('W','N');

        int nX = 0, nY = 0;
        char sDir = 'N';
        for(int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if(c == 'G') {
                switch(sDir) {
                    case 'N':
                        nY += 1;
                        break;
                    case 'E':
                        nX += 1;
                        break;
                    case 'W':
                        nX -= 1;
                        break;
                    case 'S':
                        nY -= 1;
                        break;
                }
            } else if(c == 'L') {
                sDir = left.get(sDir);
            } else {
                sDir = right.get(sDir);
            }
        }
        return (nX == 0 && nY == 0) || (sDir != 'N');
    }
}