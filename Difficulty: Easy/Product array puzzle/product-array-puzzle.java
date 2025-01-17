//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        long pro = 1;
        int n = arr.length,cnt=0;
        for(int x : arr){
            if(x!=0) pro*=x;
            else cnt++;
        }
        if(cnt>1) return new int[n];
        for(int i=0;i<n;i++){
            if(cnt==1){
                if(arr[i]==0)   arr[i]=(int)pro;
                else arr[i]=0;
            }else   arr[i] = (int)(pro/arr[i]);
        }
        return arr;
    }
}
