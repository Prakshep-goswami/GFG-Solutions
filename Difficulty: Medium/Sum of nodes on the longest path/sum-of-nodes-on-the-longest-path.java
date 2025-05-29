class Solution {
    
    public int sumOfLongRootToLeafPath(Node root) {
      
        Pair ans = longestPath(root);
        return ans.val;
    }
    
    public Pair longestPath(Node node) {
        if(node == null) {
            return new Pair(0, 0);
        }
        
        Pair ans = new Pair();
        
        Pair left = longestPath(node.left);
        
        Pair right = longestPath(node.right);
        
        if(left.len == right.len) {
            ans.len = left.len + 1;
            ans.val = Math.max(left.val, right.val) + node.data;
        }
        else if(left.len > right.len) {
            ans.len = left.len + 1;
            ans.val = left.val + node.data;
        } else {
            ans.len = right.len + 1;
            ans.val = right.val + node.data;
        }
        
        return ans;
    }
}


class Pair {
    int val;
    int len;
    
    Pair(){}
    
    Pair(int val, int len) {
        this.val = val;
        this.len = len;
    }
}