class Solution:
    def maxGold(self, mat):
        # code here
        n = len(mat)
        m = len(mat[0])
    
        prev = [mat[i][m - 1] for i in range(n)]
    
        for y in range(m - 2, -1, -1):
            curr = [0] * n
    
            for x in range(n):
    
                rightUpper = prev[x - 1] if x > 0 else 0
                right = prev[x]
    
                rightLower = prev[x + 1] if x < n - 1 else 0
                curr[x] = mat[x][y] + max(rightUpper, right, rightLower)
    
            prev = curr
    
        result = max(prev)
        return result