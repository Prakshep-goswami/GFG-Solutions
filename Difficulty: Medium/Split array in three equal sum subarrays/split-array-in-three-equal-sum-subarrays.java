//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1 || result.size() != 2) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Solution {

    public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
    int arr1[]=new int[arr.length];
    arr1[0]=arr[0];
    for(int i=1;i<arr.length;i++)
    {
        arr1[i]=arr1[i-1]+arr[i];
    }
    List<Integer> l1=new ArrayList<>();
    int k=0,l=0,s=0;
    int sum=arr1[arr.length-1];
        int count=0;
       int target = sum / 3;
        
        // If the total sum is not divisible by 3, it's impossible to split into 3 equal parts
        if (sum % 3 != 0) {
            return new ArrayList<>(Arrays.asList(-1, -1));
        }
        for(int i=0;i<arr.length;i++)
        {
            s+=(arr[i]);
             if(s==target)
            {
                count++;
               l1.add(i);
                s=0;
                
            }
            if(count==2)
            {
                
                // if(arr1[arr.length - 1] - arr1[i]==target)
                // {
                //  l1.add(i);
                return l1;
            // }
            
        }
        
    }
    return new ArrayList<Integer>(Arrays.asList(-1, -1));
    
}
}