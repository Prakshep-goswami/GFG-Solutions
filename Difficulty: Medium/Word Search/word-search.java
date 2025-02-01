//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends




class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // finding the index of the first character in the grid
                if (mat[i][j] == word.charAt(0)) {
                    if (search(mat, word, i, j, n, m, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    static private boolean search(char[][] mat, String word, int i, int j, int n, int m, int index) {
        // If all characters are matched
        if (index == word.length()) return true;
        
        // If the index exceeds the matrix capacity
        if (i < 0 || i >= n || j < 0 || j >= m || mat[i][j] != word.charAt(index)) return false;
        
        // To mark the visited cells
        char temp = mat[i][j];
        mat[i][j] = '#';
        
        // To traverse all four directions
        int directions[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for (int[] direction: directions) {
            if (search(mat, word, i + direction[0], j + direction[1], n, m, index + 1)) {
                return true;
            }
        }
        
        // reverting back to its woriginal state, If not found
        mat[i][j] = temp;
        
        return false;
    }
}