class Solution {
  public:
    string addStrings(string num1, string num2) {
        int i = num1.size() - 1, j = num2.size() - 1;
        int carry = 0;
        string result;

        while (i >= 0 || j >= 0 || carry) {
            int digit1 = (i >= 0) ? num1[i] - '0' : 0;
            int digit2 = (j >= 0) ? num2[j] - '0' : 0;

            int total = digit1 + digit2 + carry;
            carry = total / 10;

            result.push_back((total % 10) + '0');

            i--;
            j--;
        }

        reverse(result.begin(), result.end());
        return result;
    }
    
    string minSum(vector<int> &arr) {
        // code here
        sort(arr.begin(),arr.end());
        string num1 = "", num2 = "";
        for(int i=0;i<arr.size();i++){
            
            if(i%2==0) {
                if(num2=="" && arr[i]==0) continue;
                num2+=to_string(arr[i]);
            }
            else {
                if(num1=="" && arr[i]==0) continue;
                num1+=to_string(arr[i]);
            }
        }
        
        return addStrings(num1,num2);
    }
};

