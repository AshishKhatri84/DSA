//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack, adj)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, recStack, adj)) return true;
            } else if (recStack[neighbor]) {
                return true; 
            }
        }

        recStack[node] = false; 
        return false;
    }
}
