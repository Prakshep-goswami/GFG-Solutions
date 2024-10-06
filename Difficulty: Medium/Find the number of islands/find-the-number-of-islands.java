//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution {
    public int numIslands(char[][] grid) {
        // Code here
        
        int n = grid.length;
        int m = grid[0].length;
        
        int vis[][] = new int[n][m];
        int cnt = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(vis[row][col] == 0 && grid[row][col] != '0'){
                    cnt++;
                    bfs(grid,vis,row,col,n,m);
                }
            }
        }
        return cnt;
    }
    
    private void bfs(char grid[][], int vis[][], int row, int col, int n, int m){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row,col));
        
        while(!q.isEmpty()){
            Pair p = q.poll();  
            int r = p.first;
            int c = p.second;
            
            // to in all 8 directions
            for(int delrow = -1; delrow <= 1; delrow++){
                for(int delcol = -1; delcol <= 1; delcol++){
                    int nrow = r + delrow;
                    int ncol = c + delcol;
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] != '0' && vis[nrow][ncol] == 0){
                        vis[nrow][ncol] = 1;
                        q.offer(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
    
    class Pair{
        int first;
        int second;
        
        public Pair(int f, int s){
            this.first = f;
            this.second = s;
        }
    }
}