class Solution {
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        Map<Integer,String> single = new HashMap<>();
        single.put(1,"One");
        single.put(2,"Two");
        single.put(3,"Three");
        single.put(4,"Four");
        single.put(5,"Five");
        single.put(6,"Six");
        single.put(7,"Seven");
        single.put(8,"Eight");
        single.put(9,"Nine");

        Map<Integer,String> oneTens = new HashMap<>();
        oneTens.put(0,"Ten");
        oneTens.put(1,"Eleven");
        oneTens.put(2,"Twelve");
        oneTens.put(3,"Thirteen");
        oneTens.put(4,"Fourteen");
        oneTens.put(5,"Fifteen");
        oneTens.put(6,"Sixteen");
        oneTens.put(7,"Seventeen");
        oneTens.put(8,"Eighteen");
        oneTens.put(9,"Nineteen");

        Map<Integer,String> Tens = new HashMap<>();
        Tens.put(2,"Twenty");
        Tens.put(3,"Thirty");
        Tens.put(4,"Forty");
        Tens.put(5,"Fifty");
        Tens.put(6,"Sixty");
        Tens.put(7,"Seventy");
        Tens.put(8,"Eighty");
        Tens.put(9,"Ninety");

        Map<Integer,String> positions = new HashMap<>();
        positions.put(3,"Hundred");
        positions.put(4,"Thousand");
        positions.put(6,"Hundred");
        positions.put(7,"Million");
        positions.put(9,"Hundred");
        positions.put(10,"Billion");

        int length = (int) (Math.log10(num) + 1);
        String result = numWord(String.valueOf(num),length,length,new ArrayList<>(),single,oneTens,Tens,positions);
        return result;
    }

public static String numWord(String num, int pointer, int length, List<String> result, Map<Integer,String> single, Map<Integer,String> oneTens, Map<Integer,String> Tens, Map<Integer,String> positions) {
        if(pointer == 0) {
            StringBuilder sb = new StringBuilder();

            for(String word: result) {
                sb.append(word);
                sb.append(" ");
            }
            return (sb.toString()).trim();
        }
        int index = length - pointer;
        int rem = num.charAt(index)  - '0';
        if(pointer == 10) {
            result.add(single.get(rem));
            result.add(positions.get(pointer));
        } else if(pointer == 9) {
            if(rem != 0) {
                result.add(single.get(rem));
                result.add(positions.get(pointer));
            }
        } else if(pointer == 8) {
            if(rem != 0 && rem != 1) {
                result.add(Tens.get(rem));
            }
        } else if(pointer == 7) {
            if(rem != 0) {
                if((index - 1 >= 0 &&num.charAt(index - 1) - '0' == 1)) {
                    result.add(oneTens.get(rem));
                } else {
                    result.add(single.get(rem));
                }
                result.add(positions.get(pointer));
            } else {
                if((index - 1 >= 0 &&num.charAt(index - 1) - '0' == 1)) {
                    result.add(oneTens.get(rem));
                    result.add(positions.get(pointer));
                } else if((index - 1 >= 0 &&num.charAt(index - 1) - '0' != 0) || (index - 2 >= 0 && num.charAt(index-2) - '0' != 0)) {
                    result.add(positions.get(pointer));
                }
            }
        } else if(pointer == 6) {
            if(rem != 0) {
                result.add(single.get(rem));
                result.add(positions.get(pointer));
            }
        } else if(pointer == 5){
            if(rem != 0 && rem != 1) {
                result.add(Tens.get(rem));
            }
        } else if(pointer == 4) {
            if(rem != 0) {
                if((index - 1 >= 0 && num.charAt(index - 1) - '0' == 1)) {
                    result.add(oneTens.get(rem));
                } else {
                    result.add(single.get(rem));
                }
                result.add(positions.get(pointer));
            } else {
                if((index - 1 >= 0 &&num.charAt(index - 1) - '0' == 1)) {
                    result.add(oneTens.get(rem));
                    result.add(positions.get(pointer));
                } else if((index - 1 >= 0 &&num.charAt(index - 1) - '0' != 0) || (index - 2 >= 0 && num.charAt(index-2) - '0' != 0)) {
                    result.add(positions.get(pointer));
                }
            }
        } else if(pointer == 3) {
            if(rem != 0) {
                result.add(single.get(rem));
                result.add(positions.get(pointer));
            }
        } else if(pointer == 2) {
            if(rem != 0 && rem != 1) {
                result.add(Tens.get(rem));
            }
        } else if(pointer == 1) {
            if(index - 1 >= 0 && num.charAt(index - 1) - '0' == 1) {
                result.add(oneTens.get(rem));
            } else {
                if(rem != 0) {
                    result.add(single.get(rem));
                }
            }
        }

        String res = numWord(num,pointer-1,length,result,single,oneTens,Tens,positions);
        return res;
    }


}