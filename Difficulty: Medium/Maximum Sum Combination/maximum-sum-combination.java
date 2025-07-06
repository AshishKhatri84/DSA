import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // Sort both arrays in descending order
        Arrays.sort(a);
        Arrays.sort(b);
        
        int n = a.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> (y[0] - x[0]));
        
        // Add the largest sum combination (last elements of sorted arrays)
        maxHeap.offer(new int[]{a[n - 1] + b[n - 1], n - 1, n - 1});
        
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        visited.add((n - 1) + "," + (n - 1)); // Mark the first pair as visited
        
        // Extract the top k sums
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) break;
            int[] current = maxHeap.poll();
            result.add(current[0]);
            
            int indexA = current[1];
            int indexB = current[2];
            
            // Explore the next pairs
            // Pair (indexA - 1, indexB)
            if (indexA > 0) {
                String newPair1 = (indexA - 1) + "," + indexB;
                if (!visited.contains(newPair1)) {
                    maxHeap.offer(new int[]{a[indexA - 1] + b[indexB], indexA - 1, indexB});
                    visited.add(newPair1);
                }
            }
            // Pair (indexA, indexB - 1)
            if (indexB > 0) {
                String newPair2 = indexA + "," + (indexB - 1);
                if (!visited.contains(newPair2)) {
                    maxHeap.offer(new int[]{a[indexA] + b[indexB - 1], indexA, indexB - 1});
                    visited.add(newPair2);
                }
            }
        }
        
        return result;
    }
}
