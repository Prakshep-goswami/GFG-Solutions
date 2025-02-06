//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    public static Node solve(int []inorder,int[]preorder,int start,int end,int idx[])
    {
        if(start>end) return null;
        int rootVal=preorder[idx[0]];
        int i=start;
        for(;i<=end;i++)
        {
            if(inorder[i]==rootVal) break;
        }
        idx[0]++;
        Node node=new Node(rootVal);
        node.left=solve(inorder,preorder,start,i-1,idx);
        node.right=solve(inorder,preorder,i+1,end,idx);
        return node;
    }
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        int idx[]=new int[1];
        int n=preorder.length;
        return solve(inorder,preorder,0,n-1,idx);
    }
}
