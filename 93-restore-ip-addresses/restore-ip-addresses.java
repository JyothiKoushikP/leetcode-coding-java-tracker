class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() <= 3) {
            return result;
        }
        int[] dotPositions = new int[3];
        formValidIPAddress(result,dotPositions,s,0,0);
        return result;
    }

    public void formValidIPAddress(List<String> result,int[] dotPositions, String s, int pointer, int dotPointer) {
        if(dotPointer == dotPositions.length) {
            StringBuilder res = new StringBuilder();
            int p = 0, i = 0;
            while(i < s.length()) {
                if(p < dotPositions.length && dotPositions[p] == i) {
                    res.append(".");
                    p++;
                } else {
                    res.append(s.charAt(i));
                    i++;
                }
            }
            result.add(res.toString());
            return;
        }
        for(int i = pointer ; i < s.length() - 1; i++) {
            dotPositions[dotPointer] = i + 1;
            if(isValidDotPosition(s,i,dotPointer,dotPositions)) {
                formValidIPAddress(result,dotPositions,s,i + 1,dotPointer + 1);
            }
            dotPositions[dotPointer] = 0;
        }
    }

    public boolean isValidDotPosition(String s, int position, int dotPointer, int[] dotPositions) {
        int x = 0;
        int y = 0;
        int beginPosition = (dotPointer == 0) ? 0 : dotPositions[dotPointer - 1];
        int maxLength = (position - beginPosition) + 1;
        if(maxLength > 3) {
            return false;
        }
        if(maxLength > 1 && s.charAt(beginPosition) == '0') {
            return false;
        }
        for(int i = beginPosition; i <= position; i++) {
            int digit = s.charAt(i) - '0';
            x = (x * 10) + digit;
        }
        if(dotPointer == dotPositions.length - 1) {
            int lastPLength = s.length() - (position + 1);
            if(lastPLength > 3) return false;
            if(lastPLength > 1 && s.charAt(position+1) == '0') {
                return false;
            }
            for(int i = position + 1; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';
                y = (y * 10) + digit;
            }
        }
        return (x >= 0 && x <= 255) && (y >= 0 && y <= 255);
    }
}