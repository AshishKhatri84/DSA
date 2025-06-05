class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        int[] dp = new int[V];
        Arrays.fill(dp, -1);
        return dfs(graph, src, dest, dp);
    }
    private int dfs(List<List<Integer>> graph, int node, int dest, int[] dp) {
        if (node == dest) return 1;
        if (dp[node] != -1) return dp[node];
        int count = 0;
        for (int neighbor : graph.get(node)) {
            count += dfs(graph, neighbor, dest, dp);
        }
        dp[node] = count;
        return count;
    }
}