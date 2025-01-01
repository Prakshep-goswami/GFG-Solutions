//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
         HashMap<String,ArrayList<String>> map = new HashMap<>();
         ArrayList<ArrayList<String>> ans = new ArrayList<>();
         for(int i=0;i<arr.length;i++)
         {
             char ar1[] = arr[i].toCharArray();
             Arrays.sort(ar1);
             String temp = new String(ar1);
             if(!map.containsKey(temp))
             {
                 ArrayList<String> a = new ArrayList<>();
                 a.add(arr[i]);
                 map.put(temp,a);
             }
             else
             {
                 map.get(temp).add(arr[i]);
             }
         }
         ArrayList<Map.Entry<String,ArrayList<String>>> list = new ArrayList<>(map.entrySet());
         Collections.sort(list,(a,b)->{
             return a.getKey().compareTo(b.getKey());
         });
         
         for(Map.Entry<String,ArrayList<String>> entry:list)
         {
             ans.add(entry.getValue());
         }
         
         return ans;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends