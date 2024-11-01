//{ Driver Code Starts
import java.io.*;
import java.util.*;

// Driver class

// } Driver Code Ends


class Solution {
    public long maxSum(Long[] arr) {
        // code here
         long ans = 0;
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        long nwearr[] = new long[arr.length];
        boolean t = true;
        for (int k = 0; k < arr.length; k++) {
            if (t) {
                nwearr[k] = arr[i];
                i++;
                t = false;
            } else {
                nwearr[k] = arr[j];
                j--;
                t = true;
            }
        }
        for (i = 1; i < arr.length; i++) {
            ans += Math.abs(nwearr[i] - nwearr[i - 1]);
        }
        ans += Math.abs(nwearr[0] - nwearr[arr.length - 1]);
        return ans;
    }
}


//{ Driver Code Starts.
class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Long integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into Long integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            // Convert ArrayList to array
            Long[] arr = new Long[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call maxSum method and print result
            long ans = ob.maxSum(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends