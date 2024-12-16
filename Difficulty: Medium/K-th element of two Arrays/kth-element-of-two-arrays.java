//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length, m = b.length;

        if (n > m)
            return kthElement(b, a, k);

        int low = Math.max(0, k - m), high = Math.min(k, n);

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            int l1 = (mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE : a[mid1]);

            int l2 = (mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1]);
            int r2 = (mid2 == m ? Integer.MAX_VALUE : b[mid2]);

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
    return 0;
    }
}