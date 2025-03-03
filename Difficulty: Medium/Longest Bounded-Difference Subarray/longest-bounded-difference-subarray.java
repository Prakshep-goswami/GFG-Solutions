//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends



class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
         Deque<Integer> maxDq = new LinkedList<>();
        Deque<Integer> minDq = new LinkedList<>();
        int str = 0, maxLen = 0, ansStr = 0;
        for(int end = 0; end<arr.length;end++){
            while(!maxDq.isEmpty() && arr[maxDq.peekLast()] <= arr[end]){
                maxDq.pollLast();
            }
            maxDq.addLast(end);
            while(!minDq.isEmpty() && arr[minDq.peekLast()] >= arr[end]){
                minDq.pollLast();
            }
            minDq.addLast(end);
            
            while(arr[maxDq.peekFirst()]-arr[minDq.peekFirst()] > x){
                str++;
                if(maxDq.peekFirst()<str) maxDq.pollFirst();
                if(minDq.peekFirst()<str) minDq.pollFirst();
            }
            
            if(end-str + 1 > maxLen){
                maxLen = end-str + 1;
                ansStr = str;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList();
        for(int i=ansStr;i<ansStr+maxLen; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}


//{ Driver Code Starts.
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
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends