//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edge = new int[n][2];
            for (int i = 0; i < n; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minCost(edge);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    public int minCost(int[][] houses) {
        int n = houses.length;
        int min_cost = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [cost, vertex]
        Map<Integer, Integer> cache = new HashMap<>();
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int cost = edge[0];
            int u = edge[1];

            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            min_cost += cost;

            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(houses[u][0] - houses[v][0]) + Math.abs(houses[u][1] - houses[v][1]);
                    if (dist < cache.getOrDefault(v, Integer.MAX_VALUE)) {
                        cache.put(v, dist);
                        pq.offer(new int[]{dist, v});
                    }
                }
            }
        }

        return min_cost;
    }
}