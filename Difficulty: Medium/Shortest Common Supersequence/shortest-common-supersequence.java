//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        sc.nextLine();
        while (t-- > 0) {
            // taking String X and Y
            String X = sc.nextLine();
            String Y = sc.nextLine();

            // calling function shortestCommonSupersequence()
            System.out.println(new Solution().shortestCommonSupersequence(X, Y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int shortestCommonSupersequence(String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++)
            for (int j = 1; j <= l2; j++)
                dp[i][j] = (str1.charAt(i - 1) == str2.charAt(j - 1)) 
                           ? dp[i - 1][j - 1] + 1 
                           : Math.max(dp[i - 1][j], dp[i][j - 1]);

        return l1 + l2 - dp[l1][l2]; 
    }
}

