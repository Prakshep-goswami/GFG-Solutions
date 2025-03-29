//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends



class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = profit.length;
        
        int[][] jobs = new int[n][2]; // Store profit and deadline together
        for (int i = 0; i < n; i++) {
            jobs[i][0] = profit[i];   // Profit first
            jobs[i][1] = deadline[i]; // Deadline second
        }

        // Sort by profit in descending order (higher profit first)
        Arrays.sort(jobs, (a, b) -> b[0] - a[0]);

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][1]);
        }

        boolean[] slots = new boolean[maxDeadline + 1]; // Track occupied slots
        int jobCount = 0, totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(maxDeadline, jobs[i][1]); j > 0; j--) {
                if (!slots[j]) { // If slot available, schedule job
                    slots[j] = true;
                    jobCount++;
                    totalProfit += jobs[i][0];
                    break;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(jobCount);
        ans.add(totalProfit);
        return ans;
    }

    
}



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends