//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    Node root = new Node();
    public void insert(int x){
        Node temp = root;
        for(int i = 31;i>=0;i--){
            int index = (x >> i) & 1;
            if(temp.node[index]==null) temp.node[index] = new Node();
            temp = temp.node[index];
        }
    }
    public int find(int x){
        Node temp = root;
        int n = 0;
        for(int i = 31;i>=0;i--){
            int index = 1-(x >> i) & 1;
            if(temp.node[index]!=null) {
                n |= (1<<i);
            }else index = 1-index;
            temp = temp.node[index];
        }
        // System.out.println();
        return n;
    }
    public int maxXor(int[] arr) {
        // code here
        for(int i: arr) insert(i);
        int ans = 0;
        for(int i: arr) ans = Math.max(find(i),ans);
        return ans;
    }
}
class Node{
    Node[] node = new Node[2];
}