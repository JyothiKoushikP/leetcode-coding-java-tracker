class Solution {

    public int openLock(String[] deadends, String target) {
        int pos = 4;
        int digits = 10;
        Set<String> visited = new HashSet<>();
        String beginLock = "0000";
        for(String lock: deadends) {
            visited.add(lock);
        }
        if(visited.contains(beginLock)) {
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginLock);
        visited.add(beginLock);

        int depth = 0;
        while (!q.isEmpty()) {
            int level = q.size();
            for(int j = 0; j < level ; j++) {
                String present = q.remove();
                if(present.equals(target)) {
                    return depth;
                }
                for(int i = 0; i < pos; i++) {
                    StringBuilder curr = new StringBuilder(present);
                    int c = curr.charAt(i) - '0';
                    int f = (c + 1) % digits;
                    int b = (c + digits - 1) % digits; 
                    curr.setCharAt(i, (char)(f + '0'));
                    if(!visited.contains(curr.toString())) {
                        q.add(curr.toString());
                        visited.add(curr.toString());
                    }
                    curr.setCharAt(i, (char)(b + '0'));
                    if(!visited.contains(curr.toString())) {
                        q.add(curr.toString());
                        visited.add(curr.toString());
                    }
                }
            } 
            depth++;
        }
        return -1;
    }

}