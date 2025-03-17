//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean equalPartition(int arr[]) {
        return canPartition(arr);
    }

    private boolean canPartition(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) return false;

        int subsetSum = total / 2;
        Boolean[][] dp = new Boolean[n][subsetSum + 1];

        return findSubset(dp, nums, n - 1, subsetSum);
    }

    private boolean findSubset(Boolean[][] dp, int[] nums, int index, int subsetSum) {
        if (subsetSum == 0) return true;
        if (index < 0 || subsetSum < 0) return false;

        if (dp[index][subsetSum] != null) return dp[index][subsetSum];

        boolean include = findSubset(dp, nums, index - 1, subsetSum - nums[index]);
        boolean exclude = findSubset(dp, nums, index - 1, subsetSum);

        dp[index][subsetSum] = include || exclude;
        return dp[index][subsetSum];
    }
}