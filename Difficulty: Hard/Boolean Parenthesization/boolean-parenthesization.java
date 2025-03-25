//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.countWays(s));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int countWays(String s) {
        int n = s.length();
        int[][] dpTrue = new int[n][n];  // Ways to get True
        int[][] dpFalse = new int[n][n]; // Ways to get False
        
        // Base case: Single character ('T' or 'F')
        for (int i = 0; i < n; i += 2) {
            dpTrue[i][i] = (s.charAt(i) == 'T') ? 1 : 0;
            dpFalse[i][i] = (s.charAt(i) == 'F') ? 1 : 0;
        }
        
        // Fill DP tables for increasing lengths
        for (int len = 3; len <= n; len += 2) { // Lengths of expressions (3, 5, 7,...)
            for (int i = 0; i <= n - len; i += 2) {
                int j = i + len - 1; // Ending index
                
                for (int k = i + 1; k < j; k += 2) { // Possible operators
                    char op = s.charAt(k);

                    int LT = dpTrue[i][k - 1];   // Left True
                    int LF = dpFalse[i][k - 1]; // Left False
                    int RT = dpTrue[k + 1][j];   // Right True
                    int RF = dpFalse[k + 1][j]; // Right False

                    if (op == '&') {
                        dpTrue[i][j] += LT * RT;
                        dpFalse[i][j] += (LT * RF) + (LF * RT) + (LF * RF);
                    } else if (op == '|') {
                        dpTrue[i][j] += (LT * RT) + (LT * RF) + (LF * RT);
                        dpFalse[i][j] += LF * RF;
                    } else if (op == '^') {
                        dpTrue[i][j] += (LT * RF) + (LF * RT);
                        dpFalse[i][j] += (LT * RT) + (LF * RF);
                    }
                }
            }
        }
        
        return dpTrue[0][n - 1]; // Result for the full expression
    }
}
