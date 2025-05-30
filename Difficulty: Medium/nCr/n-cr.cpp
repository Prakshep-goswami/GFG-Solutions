//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int nCr(int n, int r) {
        // code here
        if(r>n){
            return 0;
        }
        vector<vector<int>>Ans(n+1,vector<int>(r+1,0));
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=min(i,r);j++){
                if(i==j||j==0){ 
                    Ans[i][j]=1;
                }else{
                    Ans[i][j]=(Ans[i-1][j]+Ans[i-1][j-1]);
                }
            }
        }
        return Ans[n][r];
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, r;
        cin >> n >> r;

        Solution ob;
        cout << ob.nCr(n, r) << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends