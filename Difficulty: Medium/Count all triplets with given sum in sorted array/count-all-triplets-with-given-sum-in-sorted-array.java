//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;

        // Step 1: Iterate through the array
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            // Step 2: Use two pointers to find triplets
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum == target) {
                    // Count all valid combinations for the current sum
                    if (arr[j] == arr[k]) {
                        // If arr[j] == arr[k], count all combinations between j and k
                        int combinations = (k - j + 1) * (k - j) / 2; // nC2
                        count += combinations;
                        break; // Move to next i since all combinations for j and k are counted
                    } else {
                        // Count individual combinations for different arr[j] and arr[k]
                        int left = 1, right = 1;

                        while (j + 1 < k && arr[j] == arr[j + 1]) {
                            left++;
                            j++;
                        }

                        while (k - 1 > j && arr[k] == arr[k - 1]) {
                            right++;
                            k--;
                        }

                        count += left * right;
                        j++;
                        k--;
                    }
                } else if (sum < target) {
                    j++; // Increase the sum by moving the left pointer
                } else {
                    k--; // Decrease the sum by moving the right pointer
                }
            }
        }

        return count;
    }
}
