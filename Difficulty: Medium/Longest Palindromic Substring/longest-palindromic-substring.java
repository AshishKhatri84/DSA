//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int start = 0, end = 0;
    public String longestPalindrome(String s) {
        helper(s.toCharArray(), 0, s.length());
        return s.substring(start, end + 1);
    }
    void helper(char[] arr, int i, int n) {
        if(i > n - 1) return;
        int left = i, right = i;
        while(right < n - 1 && arr[right] == arr[right + 1]) {
            right++;
        } 
        i = right;
        while(left > 0 && right < n - 1 && arr[left - 1] == arr[right + 1]) {
            left--;
            right++;
        }
        if(end - start < right - left) {
            start = left;
            end = right;
        }
        helper(arr, ++i, n);
    }
}