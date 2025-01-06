//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(arr);
        int i=0;
        int n=arr.length;
        int j=n-1;
        int mindiff=Integer.MAX_VALUE;
        int[] ans=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        while(i<j){
            int sum=arr[i]+arr[j];
            
            int diff=Math.abs(target-sum);
            
            if(diff<mindiff){
                mindiff=diff;
                  ans[0]=arr[i];
                  ans[1]=arr[j];
            }
            
            if(sum>target){
                j--;
            }
            
            else{
                i++;
            }
        }
       if(ans[0]!=-1 &&ans[1]!=-1){
           list.add(ans[0]);
           list.add(ans[1]);
       }
       return list;
    }
}