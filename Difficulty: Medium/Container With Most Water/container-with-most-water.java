//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution {

    public int maxWater(int arr[])
    {
        int max_water = 0, n = arr.length;
        int i=0, j = n-1;
        
        while(i<j)
        {
            max_water = Math.max(max_water, Math.min(arr[i], arr[j])*(j-i));
            if(arr[i]>arr[j]) j--;
            else i++;
        }
        return max_water;
    }
}