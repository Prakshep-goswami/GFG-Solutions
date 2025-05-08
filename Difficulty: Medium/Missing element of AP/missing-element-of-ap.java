//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        Solution solution = new Solution();
        while (t-- > 0) {
            String input = reader.readLine().trim();
            String[] parts = input.split("\\s+");
            int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

            System.out.println(solution.findMissing(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMissing(int[] arr) {
        int n = arr.length; //
        int d = 0; 
        
        if(n == 2) {
            d = arr[1] - arr[0];
        } else {
            if(arr[1] - arr[0] <= 0) {
                d = Math.max(arr[1] - arr[0], arr[2] - arr[1]);
            } else {
                d = Math.min(arr[1] - arr[0], arr[2] - arr[1]);
            }
        }
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1] + d) {
                return arr[i-1] + d;
            }
        }
        
        return arr[n-1] + d;
    }
}
