//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int p = Integer.parseInt(S[0]);
            int q = Integer.parseInt(S[1]);
            int r = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            int ans = ob.CountWays(p, q, r);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private static final int MOD = (int) (1e9 + 7);
    private long[][][][] dp = new long[3][101][101][101]; // 4D DP array

    private long add(long x, long y) {
        return (x + y) % MOD;
    }

    private long fun(int l, int p, int q, int r) {
        if (p == 0 && q == 0 && r == 0) return 1;
        if (p < 0 || q < 0 || r < 0) return 0;

        if (dp[l][p][q][r] != -1) return dp[l][p][q][r];

        long ans = 0;
        if (l == 0) {
            if (q > 0) ans = add(ans, fun(1, p, q - 1, r));
            if (r > 0) ans = add(ans, fun(2, p, q, r - 1));
        } else if (l == 1) {
            if (p > 0) ans = add(ans, fun(0, p - 1, q, r));
            if (r > 0) ans = add(ans, fun(2, p, q, r - 1));
        } else {
            if (p > 0) ans = add(ans, fun(0, p - 1, q, r));
            if (q > 0) ans = add(ans, fun(1, p, q - 1, r));
        }

        return dp[l][p][q][r] = ans;
    }

    public int CountWays(int p, int q, int r) { // Fixed method name
        long ans = 0;

        // Reset DP array to -1
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= p; j++) {
                for (int k = 0; k <= q; k++) {
                    for (int l = 0; l <= r; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        if (p > 0) ans = add(ans, fun(0, p - 1, q, r));
        if (q > 0) ans = add(ans, fun(1, p, q - 1, r));
        if (r > 0) ans = add(ans, fun(2, p, q, r - 1));

        return (int) ans;
    }
}