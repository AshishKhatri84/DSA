//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.getScore(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int getScore(int arr[], int k) {
        int n = arr.length, a = 0, b = 0;
        int[] deq = new int[n];
        deq[0] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (deq[a] - i > k) a++;
            arr[i] += arr[deq[a]];
            while (b >= a && arr[deq[b]] <= arr[i]) b--;
            deq[++b] = i;
        }
        return arr[0];
    }
}