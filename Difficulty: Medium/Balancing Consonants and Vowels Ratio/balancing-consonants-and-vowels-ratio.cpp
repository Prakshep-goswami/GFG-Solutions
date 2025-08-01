class Solution {
  public:
  int cntVowels(string &s){
      int cnt = 0;
      for(int i=0;i<s.size();i++){
          if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u'){
              cnt++;
          }
      }
      return cnt;
  }
    
    int cntConsonants(string &s){
      int cnt = 0;
      for(int i=0;i<s.size();i++){
          if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u'){
              continue;
          }
          else{
              cnt++;
          }
      }
      return cnt;
  }
    int countBalanced(vector<string>& arr) {
        // code here
        int n = arr.size();
        vector<int> final(n);
        for(int i=0;i<n;i++){
            final[i]=(cntVowels(arr[i])-cntConsonants(arr[i]));
        }
        unordered_map<int,int> mpp;
        mpp[0]=1;
        int cnt =0;
        vector<int> prefix(n,final[0]);
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+final[i];
        }
        for(int i=0;i<n;i++){
            
                cnt+= mpp[prefix[i]];
            mpp[prefix[i]]++;
            
        }
        
        return cnt;
    }
};