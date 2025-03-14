//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            int ans = obj.minCandy(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minCandy(int[] arr) {
        int n = arr.length;
        int totalCandies = n;
        int i = 1;
        while (i < n) {
            if (arr[i] == arr[i - 1]) {
                i++;
                continue;
            }
            int currentPeak = 0;
            while (i < n && arr[i] > arr[i - 1]) {
                currentPeak++;
                totalCandies += currentPeak;
                i++;
            }
            if (i == n) {
                return totalCandies;
            }
            int currentValley = 0;
            while (i < n && arr[i] < arr[i - 1]) {
                currentValley++;
                totalCandies += currentValley;
                i++;
            }
            totalCandies -= Math.min(currentPeak, currentValley);
        }
        return totalCandies;        
    }
}