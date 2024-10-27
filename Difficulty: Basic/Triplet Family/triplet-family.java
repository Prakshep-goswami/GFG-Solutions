//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public boolean findTriplet(int[] arr) {
        
        int x = 0;
        int y = 1;
        int n = arr.length;
        Arrays.sort(arr);
        
        if(n<=1) return false;
        
        while(x!=n-2)
        {
            int sum = arr[x]+arr[y];
            int i = y+1;
            while(i<n)
            {
                if(arr[i]!=sum) i++;
                else return true;
            }
            if(y<n-1) y++;
            else if(y==n-1) 
            {
                x++;
                y = x+1;
            }
        }
        
        return false;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
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
            Solution obj = new Solution();
            boolean res = obj.findTriplet(arr);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends