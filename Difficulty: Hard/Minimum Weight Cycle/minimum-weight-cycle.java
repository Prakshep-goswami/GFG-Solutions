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
    public int findMinCycle(int V, int[][] edges) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] graph = new int[V][V];

        // Initialize the graph
        for (int i = 0; i < V; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u][v] = Math.min(graph[u][v], w);
            graph[v][u] = Math.min(graph[v][u], w); // since undirected
        }

        int minCycle = INF;

        // For each edge, remove it and compute shortest path between its nodes
        for (int[] removedEdge : edges) {
            int ru = removedEdge[0], rv = removedEdge[1], rw = removedEdge[2];

            // Create a copy of the graph
            int[][] dist = new int[V][V];
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dist[i][j] = graph[i][j];
                }
            }

            // Remove current edge
            dist[ru][rv] = INF;
            dist[rv][ru] = INF;

            // Floyd-Warshall on updated graph
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }

            // If a path still exists between ru and rv, update minCycle
            if (dist[ru][rv] < INF) {
                minCycle = Math.min(minCycle, dist[ru][rv] + rw);
            }
        }

        return minCycle == INF ? -1 : minCycle;
    }
}