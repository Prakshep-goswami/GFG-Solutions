class Solution {
  public:
    int n, m, z;
    int dp[101][101][101];
    int solve(string& s1, string& s2, string& s3, int i, int j, int k){
        if (i >= n || j >= m || k >= z) return 0;
        int ans = 0;
        if (dp[i][j][k] != -1) return dp[i][j][k];
        if (s1[i] == s2[j] && s1[i] == s3[k]){
            ans = 1 + solve(s1, s2, s3, i+1, j+1, k+1);
        }
        else{
            ans = max({solve(s1, s2, s3, i+1, j, k), solve(s1, s2, s3, i, j+1, k), solve(s1, s2, s3, i, j, k+1), solve(s1, s2, s3, i+1, j, k+1), solve(s1, s2, s3, i+1, j+1, k), solve(s1, s2, s3, i, j+1, k+1)});
        }
        return dp[i][j][k] = ans;
    }
    int lcsOf3(string& s1, string& s2, string& s3) {
        n = s1.length(), m = s2.length(), z = s3.length();
        memset(dp, -1, sizeof(dp));
        return solve(s1, s2, s3, 0, 0, 0);
    }
};