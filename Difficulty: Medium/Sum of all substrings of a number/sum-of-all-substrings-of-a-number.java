class Solution {
    public static int sumSubstrings(String s) {
        int n = s.length();
        long res = 0;
        long prev = s.charAt(0) - '0';

        res = prev;

        for (int i = 1; i < n; i++) {
            int num = s.charAt(i) - '0';
            prev = prev * 10 + (long) num * (i + 1);
            res += prev;
        }
        return (int) res;  
    }
}