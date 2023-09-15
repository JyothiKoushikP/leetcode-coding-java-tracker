class Solution {
    public boolean rotateString(String s, String goal) {
        int n = goal.length();
        int i = 0;
        StringBuilder org = new StringBuilder(goal);
        while(i < n) {
            char first = org.charAt(0);
            org.deleteCharAt(0);
            org.append(first);
            if(s.equals(org.toString())) {
                return true;
            }
            i++;
        }
        return false;
    }
}