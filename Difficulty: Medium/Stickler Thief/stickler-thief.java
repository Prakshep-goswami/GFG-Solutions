//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    int f(int ind, int arr[],int dp[]){
        if(ind<0)  return 0;
        
        if(dp[ind]!=-1)return dp[ind];
        int nt=f(ind-1, arr,dp);
        int t=arr[ind]+f(ind-2, arr,dp);
        return dp[ind]=Math.max(nt, t);
    }
    public int findMaxSum(int arr[]) {
        // code here
        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);
        return f(arr.length-1, arr,dp);
        
    }
}