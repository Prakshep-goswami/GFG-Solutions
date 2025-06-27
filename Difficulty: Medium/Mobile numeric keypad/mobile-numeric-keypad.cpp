class Solution {
  public:
    int Findcnt(int n, int x, int y, vector<vector<int>> &mat,vector<vector<vector<int>>> &visited){
        if(x<0 or x>=4 or y<0 or y>=3 or mat[x][y] == -1){
            return 0;
        }
        
        if(n == 1){
            return 1;
        }
        
        if(visited[x][y][n] != -1){
            return visited[x][y][n];
        }
         
        
        int same = Findcnt(n-1,x,y,mat,visited);
        int left = Findcnt(n-1,x-1,y,mat,visited);
        int Up = Findcnt(n-1,x,y-1,mat,visited);
        int right = Findcnt(n-1,x,y+1,mat,visited);
        int down = Findcnt(n-1,x+1,y,mat,visited);
        
        
        return visited[x][y][n] = (same+left+Up+right+down);
    }
    int getCount(int n) {
        vector<vector<int>> mat = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {-1,0,-1}
        };
        
        
        int ans = 0;
        for(int i = 0;i<12;i++){
            if(i == 9 or i == 11)continue;
            
            vector<vector<vector<int>>> visited(4,vector<vector<int>>(3,vector<int>(n+1,-1)));
            
            int x = i/3;
            int y = i%3;
            
            ans += Findcnt(n,x,y,mat,visited);
        }
        
        return ans;
    }
};