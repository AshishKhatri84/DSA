//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
static final int INF = (int)1e9;

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int findMinCycle(int V, int[][] edges) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        // Build graph
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        int minCycle = INF;

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            // Temporarily remove edge (u, v)
            removeEdge(graph, u, v, w);

            // Find shortest path from u to v using Dijkstra
            int shortestPath = dijkstra(graph, u, v, V);

            // If reachable, calculate cycle weight
            if (shortestPath != INF)
                minCycle = Math.min(minCycle, shortestPath + w);

            // Restore edge
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        return (minCycle == INF) ? -1 : minCycle;
    }

    static void removeEdge(List<List<Edge>> graph, int u, int v, int w) {
        graph.get(u).removeIf(edge -> edge.to == v && edge.weight == w);
        graph.get(v).removeIf(edge -> edge.to == u && edge.weight == w);
    }

    static int dijkstra(List<List<Edge>> graph, int src, int target, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];

            if (d > dist[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.to, w = edge.weight;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist[target];
    }
}

