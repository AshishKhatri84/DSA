//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution ob = new Solution();
            int ans = ob.subsetXORSum(nums); // Call the function and store result
            System.out.println(ans);         // Output the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int subsetXORSum(int[] arr) {
        int or = 0;
        for (int num : arr) {
            or |= num;
        }
        return or * (1 << (arr.length - 1));
    }
}
