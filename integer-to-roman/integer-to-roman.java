class Solution {
    public String intToRoman(int num) {
        int[] numbers = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String res = "";
        String[] roman = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
            for(int i=numbers.length-1;i>=0 && num>0 ;i--){
                while(numbers[i] <= num){
                    num -= numbers[i];
                    res += roman[i];
                }
            }
        return res;
        }
    }