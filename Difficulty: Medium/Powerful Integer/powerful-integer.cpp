class Solution {
  public:
    int powerfulInteger(vector<vector<int>>& intervals, int k) {
        map<int,int>mp;
        int n=intervals.size();
        for(auto interval : intervals){
            mp[interval[0]] += 1;
            mp[interval[1] + 1] -= 1;
        }
        vector<pair<int,int>>v;
        for(auto x:mp){
            v.push_back({x.first,x.second});
        }
        for(int i=1;i<v.size();++i){
            v[i].second+=v[i-1].second;
        }
        int ans=-1;
        for(int i=1;i<v.size();++i){
            if(v[i-1].second>=k){
                ans=v[i].first-1;
            }
        }
        return ans;
    }
};