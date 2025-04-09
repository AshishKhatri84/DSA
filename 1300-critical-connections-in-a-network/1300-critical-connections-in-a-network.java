class Solution {
    int timer = 1;
    private void dfs(List<List<Integer>> adj, boolean[] visited, int currNode, int parentNode, int[] time, int[] lowestTime, List<List<Integer>> res) {
        if (currNode > adj.size() || visited[currNode]) {
            return;
        }
        visited[currNode] = true;
        time[currNode] = timer;
        lowestTime[currNode] = timer;
        timer += 1;
        for (int neighbour: adj.get(currNode)) {
            if (neighbour != parentNode) {
                dfs(adj, visited, neighbour, currNode, time, lowestTime, res);
                if (lowestTime[neighbour] > time[currNode]) {
                    res.add(List.of(neighbour, currNode));
                }
                lowestTime[currNode] = Math.min(lowestTime[currNode], lowestTime[neighbour]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> connection: connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int[] time = new int[n];
        int[] lowestTime = new int[n];
        Arrays.fill(lowestTime, Integer.MAX_VALUE);
        int[] timer = new int[1];
        dfs(adj, visited, 0, -1, time, lowestTime, res);
        return res;
    }
}