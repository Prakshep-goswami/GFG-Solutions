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
            int ans = sln.kthMissing(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        int n = arr.length, l = 0, r = n - 1, ans = n + k;
        
        while(l <= r){
            int mid = l + (r - l) / 2;
            
            if(arr[mid] - (mid + 1) < k)  l = mid + 1;
            else{
                ans = mid + k;
                r = mid - 1;
            }
        }
        
        return ans;
    }
}