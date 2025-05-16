//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Element implements Comparable<Element> {
        int value, row, col;
        Element(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
        public int compareTo(Element other) {
            return this.value - other.value;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length, n = arr[0].length;
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            minHeap.add(new Element(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        while (true) {
            Element minElem = minHeap.poll();
            int min = minElem.value;
            if (max - min < end - start) {
                start = min;
                end = max;
            }
            if (minElem.col + 1 == n) break;
            int nextVal = arr[minElem.row][minElem.col + 1];
            minHeap.add(new Element(nextVal, minElem.row, minElem.col + 1));
            max = Math.max(max, nextVal);
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(start);
        res.add(end);
        return res;
    }
}