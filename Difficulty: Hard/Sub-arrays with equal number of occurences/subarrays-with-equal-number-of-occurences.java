//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

// User function Template for Java

class Solution {

    public static int sameOccurrence(int arr[], int x, int y) {
        // HashMap to store the frequency of count_diff values
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        // Start with count_diff = 0 (base case)
        countMap.put(0, 1);
        
        int count_diff = 0;
        int result = 0;
        
        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Update count_diff based on x and y occurrences
            if (arr[i] == x) {
                count_diff++; // Increase count_diff when we find x
            } 
            if (arr[i] == y) {
                count_diff--; // Decrease count_diff when we find y
            }
            
            // If this count_diff has been seen before, add the frequency to result
            if (countMap.containsKey(count_diff)) {
                result += countMap.get(count_diff);
            }
            
            // Update the count_diff frequency in the map
            countMap.put(count_diff, countMap.getOrDefault(count_diff, 0) + 1);
        }
        
        return result;
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

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.sameOccurrence(arr, x, y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends