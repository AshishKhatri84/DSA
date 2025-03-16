//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.kokoEat(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int kokoEat(int[] arr, int k) {
    int n = arr.length;
        long total = 0;
        for (int p : arr) 
            total += p;
        
        int left = (int) ((total - 1) / k) + 1;
        int right = (int) ((total - n) / (k - n + 1)) + 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int time = 0;
            for (int p : arr) {
                time += (p - 1) / mid + 1;
            }
            if (time > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}