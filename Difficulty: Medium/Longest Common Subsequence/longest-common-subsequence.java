//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the lcs function with the lengths of the strings as
            // parameters
            System.out.println(obj.lcs(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    static int lcs(String s1, String s2) {
        int[] dp = new int[s1.length()];
        int size = 0;
        for(char ch : s2.toCharArray()){
            int cur = 0;
            for(int i = 0; i < dp.length; i++){
                if(cur < dp[i])
                    cur = dp[i];
                else if(ch == s1.charAt(i)){
                    dp[i] = cur + 1;
                    size = Math.max(size, cur + 1);
                }
            }
        }
        return size;
    }
}