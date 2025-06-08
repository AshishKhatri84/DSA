class Solution {
    public boolean isSumString(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= (n - i) / 2; j++) {
                if (isValid(s, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean isValid(String s, int start, int len1, int len2) {
        if ((s.charAt(start) == '0' && len1 > 1) || (s.charAt(start + len1) == '0' && len2 > 1))
            return false;

        String num1 = s.substring(start, start + len1);
        String num2 = s.substring(start + len1, start + len1 + len2);
        String sum = add(num1, num2);
        int sumLen = sum.length();

        if (start + len1 + len2 + sumLen > s.length()) return false;

        String next = s.substring(start + len1 + len2, start + len1 + len2 + sumLen);
        if (!sum.equals(next)) return false;

        if (start + len1 + len2 + sumLen == s.length()) return true;

        return isValid(s, start + len1, len2, sumLen);
    }

    private String add(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0, i = a.length() - 1, j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            res.append(sum % 10);
            carry = sum / 10;
        }
        return res.reverse().toString();
    }
}