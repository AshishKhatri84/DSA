//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countWays(String digits) {
        if (digits.charAt(0) == '0') {
            return 0;
        }

        int n = digits.length();
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int one = Character.getNumericValue(digits.charAt(i - 1));
            int two = Integer.parseInt(digits.substring(i - 2, i));

            if (1 <= one && one <= 9) {
                dp[i] += dp[i - 1];
            }
            if (10 <= two && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];        
    }
}