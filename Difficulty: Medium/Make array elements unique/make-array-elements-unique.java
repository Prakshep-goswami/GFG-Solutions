//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int A = obj.minIncrements(a);
            System.out.println(A);
        }
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution {
    public int minIncrements(int[] arr) {
        // Code here
        Arrays.sort(arr);

        HashSet<Integer> set = new HashSet<>();

        int sum = 0;

        int max = 0;

        for(int i=0;i<arr.length;i++){

            max = Math.max(arr[i],max);

            if(set.contains(arr[i])){

                sum+=max+1-arr[i];

                max++;

                set.add(max);

            }

            else{

                set.add(arr[i]);

            }

        }

        return sum;
    }
}