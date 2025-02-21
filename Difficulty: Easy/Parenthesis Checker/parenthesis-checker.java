//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    static boolean isBalanced(String x) {
        // add your code here
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<x.length();i++){
            char c=x.charAt(i);
            
            if( c == '[' || c == '{'  || c == '('){
                stack.push(c);
            }else{
                
                 // If stack is empty and we encounter a closing bracket, return false
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop from stack and check for matching pairs
                char top = stack.pop();
                if ((c == ']' && top != '[') ||
                    (c == '}' && top != '{') ||
                    (c == ')' && top != '(')) {
                    return false; // If the current closing bracket doesn't match the top, return false
                }
            
        }
        }
        
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}