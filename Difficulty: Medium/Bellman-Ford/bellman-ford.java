//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {

            int V = Integer.parseInt(read.readLine().trim());
            int E = Integer.parseInt(read.readLine().trim());

            int[][] edges = new int[E][3];

            for (int i = 0; i < E; i++) {
                String[] parts = read.readLine().trim().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);

                edges[i][0] = u;
                edges[i][1] = v;
                edges[i][2] = w;
            }

            // Read source vertex
            int S = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            int[] ptr = ob.bellmanFord(V, edges, S);

            // Print the result
            for (int i = 0; i < ptr.length; i++) {
                System.out.print(ptr[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dis = new int[V];
        int len = edges.length;
        for(int i=0;i<V;i++)
        dis[i]=100000000;
        dis[src]=0;
        for(int i=0;i<=V;i++){
            for(int j=0;j<len;j++){
                int u= edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                    if(dis[u] + w < dis[v] && dis[u]!=100000000)
                    {
                    
                        dis[v] = dis[u] + w;
                        if(i==V)
                        {
                            int[] x = new int[1];
                            x[0]=-1;
                            return x;
                        }
                    }
            }
        }
        return dis;
    }
}
