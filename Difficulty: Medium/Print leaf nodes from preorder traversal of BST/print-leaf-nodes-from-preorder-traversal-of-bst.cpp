class Solution {
  public:
    bool AnySmallerElementOnRight(int l, int r, vector<int>& preorder)
    {
        int x = preorder[l - 1];
        for(int i = l; i <= r; i++)
        {
            if(preorder[i] < x)return true;
        }
        return false;
    }
    bool AnyBiggerElementOnRight(int l, int r, vector<int>&preorder)
    {
        int x = preorder[l - 1];
        for(int i = l; i <= r; i++)
        {
            if(preorder[i] > x)return true;
        }
        return false;
    }
    void FindAndAddLeafNodes(vector<int>&preorder, 
    vector<int>&ans, int cur_ind, int r)
    {
        // cout<<"LEFT "<<cur_ind<<" RIGHT "<<r<<endl;
        bool LeftNodeExist = AnySmallerElementOnRight(cur_ind + 1, r, preorder);
        bool RightNodeExist = AnyBiggerElementOnRight(cur_ind + 1, r, preorder);
        // cout<<"LEFT EXIST "<<LeftNodeExist<<" RIGHT EXIST "<<RightNodeExist<<endl;
        if(LeftNodeExist == false && RightNodeExist == false)
        {
            ans.push_back(preorder[cur_ind]);
        }
        if(LeftNodeExist)
        {
            // perform recursion
            int left_ind = cur_ind + 1;
            int right_ind = cur_ind + 1;
            for(int i = cur_ind + 1; i <= r; i++)
            {
                if(preorder[i] < preorder[cur_ind])
                {
                    right_ind = i;
                }
            }
            FindAndAddLeafNodes(preorder, ans, left_ind, right_ind);
        }
        if(RightNodeExist)
        {
            int left_ind = -1, right_ind = -1; 
            for(int i = cur_ind + 1; i <= r; i++)
            {
                if(left_ind == -1 && preorder[i] >= preorder[cur_ind])
                {
                    left_ind = i;
                }
                if(preorder[i] >= preorder[cur_ind])
                {
                    right_ind = i;
                }
            }
            FindAndAddLeafNodes(preorder, ans, left_ind, right_ind);
        }
        
    }
    vector<int> leafNodes(vector<int>& preorder) {
        vector<int>ans;
        int cur_ind = 0, r = preorder.size() - 1;
        FindAndAddLeafNodes(preorder, ans, cur_ind, r);
        return ans;
    }
};