//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            int h[] = new int[2];
            h[0] = sc.nextInt();
            h[1] = sc.nextInt();
            Solution obj = new Solution();
            ArrayList<int[]> ans = obj.insertInterval(a, h);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[");
                System.out.print(ans.get(i)[0] + "," + ans.get(i)[1]);
                System.out.print("]");
                if (i != ans.size() - 1) System.out.print(",");
            }
            System.out.println("]");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends





class Solution {

    // Function to insert and merge intervals
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Merge all overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // Add all the remaining intervals
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // Return the result as a List<int[]>
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {4, 5}, {6, 7}, {8, 10}};
        int[] newInterval = {5, 6};

        ArrayList<int[]> res = insertInterval(intervals, newInterval);
        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
