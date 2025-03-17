//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends






//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int arr[], int sum){
        // code here
        int n = arr.length;
        int [][] dp = new int[n][sum + 1];
        for(int [] temp : dp){
            Arrays.fill(temp, -1);
        }
        return helper(arr, n - 1, sum, dp);
    }
    
    static boolean helper(int [] arr, int index, int target, int [][] dp){
        if(target == 0) return true;
        
        if(index == 0){
            return arr[0] == target;
        }
        
        if(dp[index][target] != -1){
            return (dp[index][target] == 0)?false:true;
        }
        
        boolean notTake = helper(arr, index - 1, target, dp);
        
        boolean take = false;
        if(arr[index] <= target){
            take = helper(arr, index - 1, target - arr[index], dp);
        }
        boolean res = take | notTake;
        dp[index][target] = (res == false)?0:1;
        return res;
    }
}