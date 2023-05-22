class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        int[] product = new int[m + n];
        int pointer = (m + n) - 1;
        int op = pointer;
        int carry = 0;

        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            carry = 0;
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int pro = (x * y) + carry;

                if (j == 0) {
                    while (pro != 0) {
                        product[op] += pro % 10;
                        pro /= 10;
                        op--;
                    }
                } else {
                    product[op] += pro % 10;
                    carry = pro / 10;
                    op--;
                }
            }
            pointer--;
            op = pointer;
        }

        carry = 0;
        for (int i = (m + n) - 1; i >= 0; i--) {
            int e = product[i];
            product[i] = (e + carry) % 10;
            carry = (e + carry) / 10;
        }

        StringBuilder result = new StringBuilder();

        op = (product[0] == 0) ? 1 : 0;

        for (int i = op; i < product.length; i++) {
            result.append(Integer.toString(product[i]));
        }

        return result.toString();
    }
}