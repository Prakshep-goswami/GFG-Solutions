//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends



// User function Template for Java
class Solution {
    public int countWays(String digits) {
        // code here
        int [] dp = new int[digits.length()];
        Arrays.fill(dp, -1);
        return solve(digits, dp, 0);
    }
    private int solve(String digits, int[] dp, int ind){
        if(ind == digits.length()){
            return 1;
        }
        if(digits.charAt(ind) == '0'){
            return 0;
        }
        if (dp[ind] != -1){
            return dp[ind];
        } 
        int res = solve(digits, dp, ind + 1);
        
        if(ind + 1 < digits.length()){
            int num = (digits.charAt(ind) -'0') * 10 + (digits.charAt(ind + 1) - '0');
            
            if(num <= 26){
                res += solve(digits, dp, ind + 2);
            }
        }
        return dp[ind] = res;
    }
}