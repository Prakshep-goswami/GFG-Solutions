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
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }
    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in left half
            count += mergeSortAndCount(arr, left, mid);
            // Count inversions in right half
            count += mergeSortAndCount(arr, mid + 1, right);
            // Count inversions during merge step
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }
    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        // Create temporary arrays
        int[] leftArray = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left, swaps = 0;

        // Merge leftArray and rightArray
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                // There are mid - i + 1 inversions (as all remaining elements in leftArray > rightArray[j])
                arr[k++] = rightArray[j++];
                swaps += (leftArray.length - i);
            }
        }

        // Copy remaining elements of leftArray
        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }

        return swaps;
    }
}