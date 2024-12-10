//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
     static int minRemoval(int intervals[][]) {
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        int p=-1, ans=0;
        for(int i[]:intervals){
            if(i[0]<p){
                ans++;
                p=Math.min(p,i[1]);
            }else{
                p=i[1];
            }
        }
        return ans;
    }
}
