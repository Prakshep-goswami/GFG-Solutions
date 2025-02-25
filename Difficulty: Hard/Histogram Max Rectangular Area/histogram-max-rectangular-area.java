//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        int[]prevsmaller=previous(arr);
        int[]nextsmaller=next(arr);
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            ans=Math.max(ans,((nextsmaller[i]-prevsmaller[i]-1)*arr[i]));
        }
        return ans;
    }
    public static int[] previous(int[]arr){
        int[]prev=new int[arr.length];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                prev[i]=-1;
            }else{
                prev[i]=st.peek();
            }
            st.push(i);
        }
        return prev;
    }
    public static int[] next(int[] arr){
       int[]next=new int[arr.length];
       Stack<Integer>st=new Stack<>();
       for(int i=arr.length-1;i>=0;i--){
           while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
               st.pop();
           }
           if(st.isEmpty()){
               next[i]=arr.length;
           }else{
               next[i]=st.peek();
           }
           st.push(i);
       }
       return next;
        
    }
}






//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends