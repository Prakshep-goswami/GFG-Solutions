/*
class Node {
public:
    int data;
    Node *left, *right;

    Node(int val) {
        data = val;
        left = right = nullptr;
    }
};
*/
class Solution {
   public:
  
  
    bool helper(Node* p , Node* q){
        if(!p && !q) return true;
        if((p && !q) || (!p && q) || (p -> data != q -> data)) return false;
        
        return helper(p->left,q->right);
    }
    
    bool isSymmetric(Node* root) {
       
       if(!root) return false;
       return helper(root->left,root->right);
        
    }
};