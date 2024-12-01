//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Edge cases
        if (pat.length() == 0 || txt.length() == 0 || pat.length() > txt.length()) {
            return ans;
        }

        int[] lps = lps(pat); // Compute LPS array
        
        int i = 0; // Text index
        int j = 0; // Pattern index
        
        while (i < txt.length()) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                
                // If pattern is found
                if (j == pat.length()) {
                    ans.add(i - pat.length()); // 1-based index
                    j = lps[j - 1]; // Reset j to continue searching
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1]; // Fallback using LPS
                } else {
                    i++; // Move to the next character in the text
                }
            }
        }
        
        return ans;
    }
    
    public static int[] lps(String str) {
        int len = 0;
        int i = 1;
        int[] res = new int[str.length()];
        res[0] = 0; 
        
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                res[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = res[len - 1]; // Use previous LPS value
                } else {
                    res[i] = 0;
                    i++;
                }
            }
        }
        
        return res;
    }
}