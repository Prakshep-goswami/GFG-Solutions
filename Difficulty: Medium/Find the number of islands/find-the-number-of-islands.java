//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends




class Solution {
    private static int[]rd = {-1,1,0,0,-1,-1,1,1};
    private static int[]cd = {0,0,-1,1,-1,1,-1,1};
    public int countIslands(char[][] grid) {
        // Code here
        if(grid==null||grid.length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int ic = 0;
        for(int r = 0; r<n; r++){
            for(int c = 0; c<m; c++){
                if(grid[r][c] == 'L'){
                    ic++;
                    dfs(grid,r,c,n,m);
                }
            }
        }
        return ic;
    }
    private void dfs(char[][] grid, int r, int c, int n, int m){
        if(r<0||c<0||r>=n||c>=m||grid[r][c] != 'L'){
            return;
        }
        grid[r][c] = 'W';
        for(int i = 0; i<8; i++){
            int nr = r+rd[i];
            int nc = c + cd[i];
            dfs(grid,nr,nc,n,m);
        }
    }
}