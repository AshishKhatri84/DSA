class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        boolean[] v1 = new boolean[n];
        boolean[] v2 = new boolean[n];
        int ans = Integer.MAX_VALUE;
        while (node1 != -1 || node2 != -1) {
            if (node1 != -1) {
                if (v2[node1]) ans = Math.min(ans, node1);
                if (v1[node1]) node1 = -1;
                else {
                    v1[node1] = true;
                    node1 = edges[node1];
                }
            }
            if (node2 != -1) {
                if (v1[node2]) ans = Math.min(ans, node2);
                if (v2[node2]) node2 = -1;
                else {
                    v2[node2] = true;
                    node2 = edges[node2];
                }
            }
            if (ans != Integer.MAX_VALUE) return ans;
        }
        return -1;
    }
}