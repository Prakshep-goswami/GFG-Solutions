//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.countPairsWithDiffK(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

// User function Template for Java
class Solution {
    int countPairsWithDiffK(int[] arr, int k) {
        // code here
        Map<Integer,Integer> numFreq = new HashMap<>();
        int pairs = 0;
        for(int i=0; i<arr.length; i++){
            pairs += numFreq.getOrDefault(arr[i]-k,0);
            pairs += numFreq.getOrDefault(arr[i]+k,0);
            numFreq.put(arr[i],numFreq.getOrDefault(arr[i],0)+1);
        }
        return pairs;
    }
}