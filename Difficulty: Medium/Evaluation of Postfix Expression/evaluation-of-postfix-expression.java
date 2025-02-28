//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends




class Solution {
    public int evaluate(String[] arr) {
        Stack<Integer> stk = new Stack<>();
        
        for(String ele: arr) {
            if(ele.equals("+") || ele.equals("-") || ele.equals("*") || ele.equals("/")) {
                int a = stk.pop();
                int b = stk.pop();
                int val = calculate(b, a, ele);
                stk.add(val);
            } else {
                stk.add(Integer.parseInt(ele));
            }
        }
    
        return stk.pop();
        
    }
    
    public int calculate(int a, int b, String operator) {
        switch(operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }
}




//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends