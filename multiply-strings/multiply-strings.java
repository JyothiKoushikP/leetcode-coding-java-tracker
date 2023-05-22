class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        int[] product = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int prod = x * y;

                int p1 = i + j; // index for the higher digit of the product
                int p2 = i + j + 1; // index for the lower digit of the product

                int sum = prod + product[p2]; // current sum at the lower digit index
                product[p1] += sum / 10; // carry-over to the higher digit index
                product[p2] = sum % 10; // update the lower digit index

            }
        }

        StringBuilder result = new StringBuilder();
        for (int digit : product) {
            if (!(result.length() == 0 && digit == 0)) {
                result.append(digit);
            }
        }

        return result.toString();
    }
}
