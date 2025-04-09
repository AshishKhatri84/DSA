//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] disc = new int[V], low = new int[V];
        boolean[] vis = new boolean[V], isAP = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        int[] time = {1}; 

        for (int u = 0; u < V; u++) {
            if (!vis[u]) dfs(u, -1, disc, low, vis, isAP, adj, time);
        }

        for (int i = 0; i < V; i++) if (isAP[i]) res.add(i);
        if (res.isEmpty()) res.add(-1);
        return res;
    }

    static void dfs(int u, int parent, int[] disc, int[] low, boolean[] vis,
                    boolean[] isAP, List<List<Integer>> adj, int[] time) {
        vis[u] = true;
        disc[u] = low[u] = time[0]++;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == parent) continue;
            if (!vis[v]) {
                children++;
                dfs(v, u, disc, low, vis, isAP, adj, time);
                low[u] = Math.min(low[u], low[v]);
                if (parent != -1 && low[v] >= disc[u]) isAP[u] = true;
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (parent == -1 && children > 1) isAP[u] = true;
    }
}
