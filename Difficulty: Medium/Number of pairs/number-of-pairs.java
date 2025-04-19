//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public long countPairs(int x[], int y[], int M, int N) {
        Arrays.sort(y);
        
        int[] countY = new int[5];
        for (int i = 0; i < N; i++) {
            if (y[i] < 5) countY[y[i]]++;
        }

        long totalPairs = 0;
        for (int i = 0; i < M; i++) {
            totalPairs += countForX(x[i], y, N, countY);
        }

        return totalPairs;
    }

    long countForX(int x, int[] y, int n, int[] countY) {
        if (x == 0) return 0;
        if (x == 1) return countY[0];

        int idx = upperBound(y, x);
        long ans = n - idx;

        ans += countY[0] + countY[1];

        if (x == 2) {
            ans -= (countY[3] + countY[4]);
        }
        if (x == 3) {
            ans += countY[2];
        }

        return ans;
    }

    int upperBound(int[] arr, int val) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= val)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
