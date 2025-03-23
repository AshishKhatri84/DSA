//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int countPaths(int n, List<List<Integer>> roads) {
        final int MOD = 1_000_000_007;

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (List<Integer> road : roads) {
            int start = road.get(0);
            int end = road.get(1);
            int weight = road.get(2);
            graph.get(start).add(new int[]{end, weight});
            graph.get(end).add(new int[]{start, weight});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        long[] shortestTime = new long[n];
        Arrays.fill(shortestTime, Long.MAX_VALUE);
        shortestTime[0] = 0;

        int[] pathCount = new int[n];
        pathCount[0] = 1;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currTime = curr[0];
            int currNode = (int) curr[1];

            if (currTime > shortestTime[currNode]) {
                continue;
            }

            for (int[] neighbor : graph.get(currNode)) {
                int neighborNode = neighbor[0];
                int travelTime = neighbor[1];

                long newTime = currTime + travelTime;

                if (newTime < shortestTime[neighborNode]) {
                    shortestTime[neighborNode] = newTime;
                    pathCount[neighborNode] = pathCount[currNode];
                    pq.offer(new long[]{newTime, neighborNode});
                } else if (newTime == shortestTime[neighborNode]) {
                    pathCount[neighborNode] = (pathCount[neighborNode] + pathCount[currNode]) % MOD;
                }
            }
        }
        return pathCount[n - 1];
    }
}