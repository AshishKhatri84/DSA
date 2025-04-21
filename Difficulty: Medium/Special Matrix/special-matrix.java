//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for (int i = 0; i < k; i++) {
                String[] s1 = br.readLine().trim().split(" ");
                for (int j = 0; j < 2; j++) {
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static final int MOD = 1000000007;

    public int FindWays(int n, int m, int[][] blocked_cells) {
        boolean[][] blocked = new boolean[n + 1][m + 1];
        
        for (int[] cell : blocked_cells) {
            blocked[cell[0]][cell[1]] = true;
        }

        int[][] dp = new int[n + 1][m + 1];

        if (!blocked[1][1]) {
            dp[1][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (blocked[i][j]) continue;
                if (i > 1) dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                if (j > 1) dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
            }
        }

        return dp[n][m];
    }
}
