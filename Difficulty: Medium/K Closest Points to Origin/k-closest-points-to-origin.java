//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(a.dist,b.dist));
        for(int i=0;i<points.length;i++){
            int[] j=points[i];
            double dist=Math.sqrt(Math.pow(j[0],2)+Math.pow(j[1],2));
            pq.offer(new Pair(i,dist));
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            ans[i]=points[pq.peek().ind];
            pq.poll();
        }
        return ans;
    }
}
class Pair{
    int ind;
    double dist;
    Pair(int i,double d){
        this.ind=i;
        this.dist=d;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends