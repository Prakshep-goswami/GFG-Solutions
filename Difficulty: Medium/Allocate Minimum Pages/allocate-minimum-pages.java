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
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends





//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if( k > arr.length) 
        return -1;
        int beg = 0, end = 0;
        for (int i : arr) {
            beg = Math.max(beg,i);
            end += i;
            
        }
        int ans = beg ;
        while (beg <= end ) {
            int mid = (beg + end )/2;
            if(isPossible(arr,k,mid)) {
                ans = mid ;
                end = mid -1;
            }
            else{
                beg = mid + 1;
            }
        }
            return ans ;
        }
        static boolean isPossible (int[] arr , int k , int maxPages) {
            int tot = 1, sum =0;
            for (int i : arr) {
                sum += i;
                if (sum > maxPages) {
                    tot++;
                    sum = i;
                }
                
            }
            return tot <= k;
        }
        
    }