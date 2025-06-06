class Solution {
  public:
    vector<int> search(string &pat, string &txt) {
        int m = pat.size();
        int n = txt.size();
        int d = 26;
        int mod = 1e9 + 7;

        // Precompute powers of d from d^0 to d^(m-1)
        vector<int> powers(m);
        powers[0] = 1;
        for (int i = 1; i < m; i++) {
            powers[i] = (1LL * powers[i - 1] * d) % mod;
        }

        // Calculate hash for pattern
        int patHash = 0;
        for (int i = 0; i < m; i++) {
            int val = pat[i] - 'a' + 1;
            patHash = (patHash + 1LL * val * powers[m - i - 1]) % mod;
        }

        // Calculate hash for first window in text
        int txtHash = 0;
        for (int i = 0; i < m; i++) {
            int val = txt[i] - 'a' + 1;
            txtHash = (txtHash + 1LL * val * powers[m - i - 1]) % mod;
        }

        vector<int> ans;
        if (txtHash == patHash) ans.push_back(1); // 1-based index

        // Rolling hash
        int i=1,j=m;
        while(j<n) {
            int leftVal = txt[i-1] - 'a' + 1;
            int newVal = txt[j] - 'a' + 1;

            // Remove the leftmost character
            txtHash = (txtHash - 1LL * leftVal * powers[m - 1]) % mod;
            if (txtHash < 0) txtHash += mod;

            // Multiply current hash by d
            txtHash = (1LL * txtHash * d) % mod;

            // Add new character
            txtHash = (txtHash + newVal) % mod;

            if (txtHash == patHash) ans.push_back(i + 1); // 1-based index
            i++;
            j++;
        }

        return ans;
    }
}; 