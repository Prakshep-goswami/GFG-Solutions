class Solution {
  public:
    int helper(vector<vector<int>> &grid, int row, int col, vector<vector<int>> &dp){
        if(row==0 && col==0 && grid[row][col]==0) return 1;
        if(row<0 || col<0 || grid[row][col]==1) return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        int up = helper(grid, row-1, col, dp);
        int left = helper(grid, row, col-1, dp);
        dp[row][col] = up+left;
        return dp[row][col];
    }
    int uniquePaths(vector<vector<int>> &grid) {
        // code here
        vector<vector<int>> dp(grid.size(), vector<int>(grid[0].size(),-1));
        int paths = helper(grid, grid.size()-1, grid[0].size()-1, dp);
        return paths;
        
    }
};