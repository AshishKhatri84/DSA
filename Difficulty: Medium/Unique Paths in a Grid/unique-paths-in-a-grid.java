class Solution {
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return 0;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 || (i == 0 && j == 0)) continue;
                int fromTop = i > 0 ? dp[i - 1][j] : 0;
                int fromLeft = j > 0 ? dp[i][j - 1] : 0;
                dp[i][j] = fromTop + fromLeft;
            }
        }
        return dp[n - 1][m - 1];
    }
}