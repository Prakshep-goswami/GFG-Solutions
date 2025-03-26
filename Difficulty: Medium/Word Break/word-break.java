//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public Boolean[] dp;
    public Node root;
    
    public boolean fun(int index, String s){
        if(index >= s.length()) return true;
        if(dp[index]!= null) return dp[index];
        
        Node temp = root;
        for(int j = index; j<s.length(); j++){
            if(temp.links[s.charAt(j) - 'a']==null) break;
            temp = temp.links[s.charAt(j) - 'a'];
            if(temp.end && fun(j+1, s)){
                return dp[index] = true;
            }
        }
        
        return dp[index] = false;
    }
    public boolean wordBreak(String s, String[] dictionary) {
       root = new Node();
       for(String str : dictionary){
           Node temp = root;
           for(char ch : str.toCharArray()){
               if(temp.links[ch - 'a'] == null){
                   temp.links[ch - 'a'] = new Node();
               }
               temp = temp.links[ch - 'a'];
           }
           temp.end = true;
       }
        dp = new Boolean[s.length()];
        return fun(0,s);
    }
}

class Node{
    public Node[] links;
    public boolean end;
    
    public Node(){
        links = new Node[26];
        end = false;
    }
}