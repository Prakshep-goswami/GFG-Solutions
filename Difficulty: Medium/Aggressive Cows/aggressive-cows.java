//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // Sort the stalls array to ensure the cows are placed in increasing order of stall positions
        Arrays.sort(stalls);
        
        int n = stalls.length; // Total number of stalls
        int min = 1; // Minimum possible distance between two cows
        int max = stalls[n - 1] - stalls[0]; // Maximum possible distance between first and last stall
        
        // Perform binary search to find the largest minimum distance
        while (min <= max) {
            int mid = (min + max) >> 1; // Calculate the mid value (distance to check)
            
            // Check if we can place all cows with at least 'mid' distance apart
            if (canweplace(stalls, mid, k) == true) {
                // If it's possible, search for a larger minimum distance
                min = mid + 1;
            } else {
                // If not possible, search for a smaller minimum distance
                max = mid - 1;
            }
        }
        // Return the largest minimum distance where cows can be placed
        return max;
    }
    
    // Helper function to check if we can place 'k' cows in stalls with at least 'no' distance apart
    public static boolean canweplace(int arr[], int no, int k) {
        int cw = 1; // Count of cows placed, starting with placing the first cow
        int li = 0; // Index of the last stall where a cow was placed
        
        // Iterate over the stalls to check placement of cows
        for (int i = 1; i < arr.length; i++) {
            // If the current stall is at least 'no' distance from the last placed cow
            if (arr[i] - arr[li] >= no) {
                cw++; // Place the cow at the current stall
                li = i; // Update the last placed cow index
            }
            // If we have placed all 'k' cows successfully, return true
            if (cw >= k) {
                return true;
            }
        }
        // If we cannot place all 'k' cows, return false
        return false;
    }
}