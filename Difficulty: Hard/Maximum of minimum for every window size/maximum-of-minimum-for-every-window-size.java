//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends




class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n = arr.length , left[] = new int[n] , right[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st = new Stack<>();
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int res[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            int range = right[i] - left[i] - 1;
        // System.out.println(range - 1);
            res[range - 1] = Math.max(res[range - 1] , arr[i]); //0 index
        }
        for(int i = n - 2 ; i >= 0 ; i--){
            res[i] = Math.max(res[i] , res[i + 1]);
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i : res) ans.add(i);
        return ans;
    }
}