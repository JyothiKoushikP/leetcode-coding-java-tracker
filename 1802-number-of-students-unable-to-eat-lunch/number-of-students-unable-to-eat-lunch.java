class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> sq = new LinkedList();
        for(int i = 0; i < students.length; i++) {
            sq.add(i);
        }
        int curr = 0;
        Map<Integer,Integer> rejected = new HashMap();
        while(curr < sandwiches.length) {
            if(rejected.containsKey(curr) && rejected.get(curr) == sq.peek()) {
                break;
            }
            if(students[sq.peek()] == sandwiches[curr]) {
                sq.remove();
                curr++;
            } else {
                int s = sq.remove();
                sq.add(s);
                if(!rejected.containsKey(curr)) {
                    rejected.put(curr,s);
                }
            }
        }
        return sq.size();
    }
}