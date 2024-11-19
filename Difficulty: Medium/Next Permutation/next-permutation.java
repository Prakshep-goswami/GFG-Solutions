//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends
// User function Template for Java


class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int i = n - 1;
        // Find the first decreasing element from the right
        for (; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                break;
            }
        }

        if (i > 0) {
            int index = i;
            // Find the element just larger than arr[i-1]
            for (int j = n - 1; j >= i; j--) {
                if (arr[j] > arr[i - 1]) {
                    index = j;
                    break;
                }
            }
            // Swap the elements
            int temp = arr[i - 1];
            arr[i - 1] = arr[index];
            arr[index] = temp;
        }

        // Reverse the elements from index i to the end
        int start = i, end = n - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}


//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends