//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.countPS(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countPS(String s) {
        int count = 0, n = s.length();

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + (center % 2); // Handles even-length cases

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                // Only count substrings of length 2 or more
                if (right - left > 0) {
                    count++;
                }
                left--;
                right++;
            }
        }

        return count;
    }
}
