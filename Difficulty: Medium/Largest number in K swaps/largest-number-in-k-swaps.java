//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    String max;
    public String findMaximumNum(String s, int k) {
        max = s;
        findMaxHelper(s.toCharArray(), k, 0);
        return max;
    }
    private void findMaxHelper(char[] s, int k, int idx) {
        if (k == 0 || idx == s.length) {
            return;
        }
        char maxDigit = s[idx];
        for (int i = idx + 1; i < s.length; i++) {
            if (s[i] > maxDigit) {
                maxDigit = s[i];
            }
        }
        if (maxDigit != s[idx]) {
            for (int i = s.length - 1; i > idx; i--) {
                if (s[i] == maxDigit) {
                    swap(s, idx, i);
                    String current = new String(s);
                    if (current.compareTo(max) > 0) {
                        max = current;
                    }
                    findMaxHelper(s, k - 1, idx + 1);
                    swap(s, idx, i); 
                }
            }
        } else {
            findMaxHelper(s, k, idx + 1);
        }
    }
    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}