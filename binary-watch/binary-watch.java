class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        int[] hours = new int[12];
        int[] minutes = new int[60];
        countOnebits(hours);
        countOnebits(minutes);
        List<String> result = new ArrayList();
        for(int i = 0; i < hours.length; i++) {
            for(int j = 0; j < minutes.length; j++) {
                if(hours[i] + minutes[j] == turnedOn) {
                    String res = "";
                    if((Integer.toString(j)).length() == 1) {
                        res = Integer.toString(i) + ":0" + Integer.toString(j);
                    } else {
                        res = Integer.toString(i) + ":" + Integer.toString(j);
                    }
                        result.add(res);
                }
            }
        }
        return result;
    }

    public void countOnebits(int[] arr) {
        for(int i = 1; i < arr.length;i++) {
            arr[i] = arr[i & (i-1)] + 1;
        }
    }
}