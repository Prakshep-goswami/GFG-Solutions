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

            int src = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            int[] res = obj.dijkstra(V, edges, src);

            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends

class Solution {
    // Function to find the shortest distance of all the vertices from the source vertex src.
    public static int[] dijkstra(int V, int[][] edges, int src) {
        // Create adjacency list: node -> list of (neighbor, weight)
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Since it's an undirected graph, add both directions
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        // Distance array, initialized with "infinity"
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min-heap priority queue: stores (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currDist = current[0];
            int u = current[1];

            // Traverse all adjacent vertices
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (currDist + weight < dist[v]) {
                    dist[v] = currDist + weight;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        return dist;
    }
}