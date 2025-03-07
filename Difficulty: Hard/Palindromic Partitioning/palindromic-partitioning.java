//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int[][] dp;

    static int palindromicPartition(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return minCuts(s, 0, n - 1);
    }

    private static int minCuts(String s, int i, int j) {
        if (i >= j || isPalindrome(s, i, j)) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int minCuts = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            if (isPalindrome(s, i, k)) {  // Only partition if left part is palindrome
                int cuts = 1 + minCuts(s, k + 1, j);
                minCuts = Math.min(minCuts, cuts);
            }
        }
        return dp[i][j] = minCuts;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
