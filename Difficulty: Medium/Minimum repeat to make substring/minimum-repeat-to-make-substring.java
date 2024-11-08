//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A, B));
        }
        out.close();
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    static int minRepeats(String s1, String s2) {
        // code here
        for(char a:s2.toCharArray()){

            String str=String.valueOf(a);

            if(!(s1.contains(str))){

 

                return -1;

            }

        }

        String st="";

        int op=1;

        while(op<500){

            st+=s1;

            if(st.contains(s2)){

                return op;

            }

            op++;

        }

        return -1;
    }
};