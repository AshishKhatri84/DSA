import java.util.Arrays;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(text1, text2, m - 1, n - 1, dp);
    }

    private int fun(String t1, String t2, int t1i, int t2i, int[][] dp) {
        if (t1i < 0 || t2i < 0) {
            return 0;
        }
        if (dp[t1i][t2i] != -1) {
            return dp[t1i][t2i];
        }
        if (t1.charAt(t1i) == t2.charAt(t2i)) {
            dp[t1i][t2i] = 1 + fun(t1, t2, t1i - 1, t2i - 1, dp);
            return dp[t1i][t2i];
        } else {
            dp[t1i][t2i] = Math.max(fun(t1, t2, t1i, t2i - 1, dp), fun(t1, t2, t1i - 1, t2i, dp));
            return dp[t1i][t2i];
        }
    }
}