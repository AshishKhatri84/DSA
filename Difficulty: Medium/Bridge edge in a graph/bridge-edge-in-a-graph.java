//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    private int time;
    private boolean foundBridge;

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        time = 0;
        foundBridge = false;
        boolean[] visited = new boolean[V];
        int[] disc = new int[V]; 
        int[] low = new int[V];  

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, disc, low, adj, c, d);
            }
        }

        return foundBridge;
    }

    private void dfs(int u, int parent, boolean[] visited, int[] disc, int[] low,
                     List<List<Integer>> adj, int c, int d) {

        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj.get(u)) {
            if (v == parent) continue; 

            if (!visited[v]) {
                dfs(v, u, visited, disc, low, adj, c, d);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    if ((u == c && v == d) || (u == d && v == c)) {
                        foundBridge = true;
                    }
                }

            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            // V and E on separate lines
            int V = Integer.parseInt(sc.nextLine().trim());
            int E = Integer.parseInt(sc.nextLine().trim());

            // Using a 2D array to store edges.
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                // Use split("\\s+") to handle one or more whitespace characters
                String[] parts = sc.nextLine().trim().split("\\s+");
                edges[i][0] = Integer.parseInt(parts[0]);
                edges[i][1] = Integer.parseInt(parts[1]);
            }

            // c and d on separate lines
            int c = Integer.parseInt(sc.nextLine().trim());
            int d = Integer.parseInt(sc.nextLine().trim());

            Solution obj = new Solution();
            boolean result = obj.isBridge(V, edges, c, d);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends