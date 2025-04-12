//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    int n;
    int m;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
         n=image.length;
        m=image[0].length;
        
        int vis[][]=new int[n][m];
        
        dfs(image,sr,sc,vis,image[sr][sc],newColor);
        return image;
    }
    
    public void dfs(int[][] image ,int r,int c,int[][] vis,int currColor,int newColor){
        if(r<0 || r>=n || c<0 || c>=m || image[r][c]!=currColor || vis[r][c]==1){
            return ;
        }
        
         vis[r][c]=1;
         image[r][c]=newColor;
         
         //up
         dfs(image,r-1,c,vis,currColor,newColor);
         //right
         dfs(image,r,c+1,vis,currColor,newColor);
         //down
         dfs(image,r+1,c,vis,currColor,newColor);
         //left
         dfs(image,r,c-1,vis,currColor,newColor);
    }
}