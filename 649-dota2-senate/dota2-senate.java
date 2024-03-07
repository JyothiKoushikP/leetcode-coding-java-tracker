class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for(int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            if(c == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        while(!radiant.isEmpty() && !dire.isEmpty()) {
            for(int i = 0; i < senate.length(); i++) {
                char c = senate.charAt(i);
                if(c == 'R') {
                    if(!radiant.isEmpty() && radiant.peek() == i) {
                        if(dire.isEmpty()) {
                            return "Radiant";
                        } else {
                            dire.remove();
                        }
                        int index = radiant.remove();
                        radiant.add(index);
                    }
                } else {
                    if(!dire.isEmpty() && dire.peek() == i) {
                        if(radiant.isEmpty()) {
                            return "Dire";
                        } else {
                            radiant.remove();
                        }
                        int index = dire.remove();
                        dire.add(index);
                    }
                }
            }
        }
        return dire.isEmpty() ? "Radiant" : "Dire";
    }
}