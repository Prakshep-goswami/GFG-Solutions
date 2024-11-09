//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    String minSum(int[] arr) {
        // code here
         int[] count = new int[10];
        
        // Count occurrences of each digit in the array
        for (int x : arr) count[x]++;
        
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        boolean toggle = true;
        
        // Split digits between two numbers to minimize sum
        for (int i = 1; i < 10; i++) {
            while (count[i] > 0) {
                if (toggle) {
                    num1.append(i);
                } else {
                    num2.append(i);
                }
                toggle = !toggle;
                count[i]--;
            }
        }
        
        // Calculate sum of num1 and num2 represented by strings
        StringBuilder sumResult = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            sumResult.append(sum % 10);
            carry = sum / 10;
        }

        sumResult.reverse();
        
        // Remove leading zeroes
        while (sumResult.length() > 1 && sumResult.charAt(0) == '0') {
            sumResult.deleteCharAt(0);
        }
        
        return sumResult.toString();
         
    }
}