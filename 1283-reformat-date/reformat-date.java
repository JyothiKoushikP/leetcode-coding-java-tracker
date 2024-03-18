class Solution {
    public String reformatDate(String date) {
        Map<String,String> monthMap = new HashMap();
        createMappings(monthMap);
        String[] parts = date.split(" ");
        StringBuilder sb = new StringBuilder();

        //add year
        sb.append(parts[parts.length - 1]);
        sb.append('-');

        //add months
        sb.append(monthMap.get(parts[1]));
        sb.append('-');

        //add Day
        String day = parts[0];
        sb.append(day.length() == 4 ? day.substring(0,2) : "0" + day.substring(0,1));
        return sb.toString();
    }

    public void createMappings(Map<String,String> monthMap) {
        String[] months = new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

        for (int i = 0; i < months.length; i++) {
            String monthNumber;
            if (i < 9) {
                monthNumber = "0" + (i + 1);
            } else {
                monthNumber = String.valueOf(i + 1);
            }
            monthMap.put(months[i], monthNumber);
        }
    }


}