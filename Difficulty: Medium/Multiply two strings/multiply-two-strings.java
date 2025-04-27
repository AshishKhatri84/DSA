//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String multiplyStrings(String s1, String s2) {
        // Handle leading zeros first
        s1 = normalize(s1);
        s2 = normalize(s2);

        // If either number becomes "0" after normalization
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }

        // Handle negative signs
        boolean isNegative = false;
        if (s1.charAt(0) == '-') {
            isNegative = !isNegative;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            isNegative = !isNegative;
            s2 = s2.substring(1);
        }

        int n = s1.length();
        int m = s2.length();
        int[] result = new int[n + m];

        // Multiply each digit
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int digit1 = s1.charAt(i) - '0';
                int digit2 = s2.charAt(j) - '0';
                int mul = digit1 * digit2;
                int sum = result[i + j + 1] + mul;
                
                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }

        // Build the result string
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        for (; i < result.length; i++) {
            sb.append(result[i]);
        }

        // If result is negative, prepend "-"
        if (isNegative) {
            sb.insert(0, '-');
        }

        return sb.toString();
    }

    private String normalize(String s) {
        int i = 0;
        int n = s.length();
        boolean isNegative = false;

        if (i < n && s.charAt(i) == '-') {
            isNegative = true;
            i++;
        }

        // Skip all leading zeros
        while (i < n && s.charAt(i) == '0') {
            i++;
        }

        String numberPart = (i == n) ? "0" : s.substring(i);
        if (isNegative && !numberPart.equals("0")) {
            return "-" + numberPart;
        } else {
            return numberPart;
        }
    }
}